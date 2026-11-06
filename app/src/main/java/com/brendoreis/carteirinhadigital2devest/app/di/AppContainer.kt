package com.brendoreis.carteirinhadigital2devest.app.di

import com.brendoreis.carteirinhadigital2devest.core.auth.SessionTokenStore
import com.brendoreis.carteirinhadigital2devest.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.repository.LoginRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
    val turmaRepository: TurmaRepository
    val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository
}
