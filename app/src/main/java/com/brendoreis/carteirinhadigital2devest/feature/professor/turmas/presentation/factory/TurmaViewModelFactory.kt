package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.TurmaViewModel
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository.TurmaRepository

class TurmaViewModelFactory(
    private val repository: TurmaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmaViewModel::class.java)) {
            return TurmaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}
