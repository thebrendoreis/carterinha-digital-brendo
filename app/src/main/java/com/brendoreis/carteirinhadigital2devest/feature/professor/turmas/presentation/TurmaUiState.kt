package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation

import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.model.Turma

data class TurmaUiState(
    val isLoading: Boolean = false,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)
