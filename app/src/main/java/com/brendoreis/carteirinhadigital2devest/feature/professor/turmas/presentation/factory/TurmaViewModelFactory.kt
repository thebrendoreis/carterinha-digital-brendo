package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.TurmaViewModel

class TurmaViewModelFactory(private val repository: TurmaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TurmaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
