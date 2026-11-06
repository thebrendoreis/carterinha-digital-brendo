package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.data.repository

import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.data.remote.service.TurmaApi
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.model.Turma
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import retrofit2.HttpException
import java.io.IOException

class ApiTurmaRepositoryImpl(private val api: TurmaApi) : TurmaRepository {
    override suspend fun listar(): Result<List<Turma>> = runCatching {
        api.listar().map { it.toDomain() }
    }.recoverCatching { error ->
        throw when (error) {
            is HttpException -> if (error.code() == 401) {
                IllegalStateException("Sua sessão expirou. Faça login novamente.")
            } else {
                IllegalStateException("Erro ao carregar turmas (${error.code()}).")
            }
            is IOException -> IllegalStateException("Não foi possível conectar à API.")
            else -> IllegalStateException(error.message ?: "Erro ao carregar turmas.")
        }
    }
}
