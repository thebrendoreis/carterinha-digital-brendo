package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TurmaViewModel(private val repository: TurmaRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(TurmaUiState())
    val uiState = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            repository.listar()
                .onSuccess { turmas -> _uiState.update { it.copy(isLoading = false, turmas = turmas) } }
                .onFailure { error ->
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = error.message ?: "Erro ao carregar turmas.")
                    }
                }
        }
    }
}
