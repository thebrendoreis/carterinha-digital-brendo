package com.brendoreis.carteirinhadigital2devest.app.di

import com.brendoreis.carteirinhadigital2devest.core.auth.SessionTokenStore
import com.brendoreis.carteirinhadigital2devest.core.network.NetworkClient
import com.brendoreis.carteirinhadigital2devest.feature.aluno.unidadescurriculares.data.remote.service.UnidadeCurricularApi
import com.brendoreis.carteirinhadigital2devest.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.brendoreis.carteirinhadigital2devest.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.brendoreis.carteirinhadigital2devest.feature.login.data.remote.service.AuthApi
import com.brendoreis.carteirinhadigital2devest.feature.login.data.repository.ApiLoginRepositoryImpl
import com.brendoreis.carteirinhadigital2devest.feature.login.data.repository.FakeAuthRepository
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.repository.LoginRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.data.remote.service.TurmaApi
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.data.repository.ApiTurmaRepositoryImpl
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.remote.service.ProfessorUnidadeCurricularApi
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.repository.ApiProfessorUnidadeCurricularRepositoryImpl
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(
        baseUrl = BASE_URL,
        sessionTokenStore = sessionTokenStore
    )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularApi::class.java)
    }

    private val turmaApi: TurmaApi by lazy {
        networkClient.createAuthenticated(TurmaApi::class.java)
    }

    private val professorUnidadeCurricularApi: ProfessorUnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(ProfessorUnidadeCurricularApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }

    override val turmaRepository: TurmaRepository by lazy {
        ApiTurmaRepositoryImpl(api = turmaApi)
    }

    override val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository by lazy {
        ApiProfessorUnidadeCurricularRepositoryImpl(api = professorUnidadeCurricularApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}
