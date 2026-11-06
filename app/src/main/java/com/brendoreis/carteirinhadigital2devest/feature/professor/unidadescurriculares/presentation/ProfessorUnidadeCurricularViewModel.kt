package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfessorUnidadeCurricularViewModel(
    private val repository: ProfessorUnidadeCurricularRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfessorUnidadeCurricularUiState())
    val uiState = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            repository.listar()
                .onSuccess { unidades -> _uiState.update { it.copy(isLoading = false, unidades = unidades) } }
                .onFailure { error ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = error.message ?: "Erro ao carregar unidades curriculares."
                        )
                    }
                }
        }
    }
}
