package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation

import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.model.ProfessorUnidadeCurricular

data class ProfessorUnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<ProfessorUnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)
