package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository

import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.model.ProfessorUnidadeCurricular

interface ProfessorUnidadeCurricularRepository {
    suspend fun listar(): Result<List<ProfessorUnidadeCurricular>>
}
