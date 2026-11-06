package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.repository

import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.remote.service.ProfessorUnidadeCurricularApi
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.model.ProfessorUnidadeCurricular
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import retrofit2.HttpException
import java.io.IOException

class ApiProfessorUnidadeCurricularRepositoryImpl(
    private val api: ProfessorUnidadeCurricularApi
) : ProfessorUnidadeCurricularRepository {
    override suspend fun listar(): Result<List<ProfessorUnidadeCurricular>> = runCatching {
        api.listar().map { it.toDomain() }
    }.recoverCatching { error ->
        throw when (error) {
            is HttpException -> if (error.code() == 401) {
                IllegalStateException("Sua sessão expirou. Faça login novamente.")
            } else {
                IllegalStateException("Erro ao carregar unidades curriculares (${error.code()}).")
            }
            is IOException -> IllegalStateException("Não foi possível conectar à API.")
            else -> IllegalStateException(error.message ?: "Erro ao carregar unidades curriculares.")
        }
    }
}
