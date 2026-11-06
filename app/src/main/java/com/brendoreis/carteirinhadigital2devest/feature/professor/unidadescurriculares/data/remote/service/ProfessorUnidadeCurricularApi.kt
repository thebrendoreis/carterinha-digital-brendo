package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.remote.service

import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.remote.dto.ProfessorUnidadeCurricularDto
import retrofit2.http.GET

interface ProfessorUnidadeCurricularApi {
    @GET("professores/me/unidades-curriculares")
    suspend fun listar(): List<ProfessorUnidadeCurricularDto>
}
