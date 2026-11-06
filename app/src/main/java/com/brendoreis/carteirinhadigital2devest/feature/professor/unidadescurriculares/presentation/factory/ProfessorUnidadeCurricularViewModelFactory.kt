package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.ProfessorUnidadeCurricularViewModel

class ProfessorUnidadeCurricularViewModelFactory(
    private val repository: ProfessorUnidadeCurricularRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfessorUnidadeCurricularViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfessorUnidadeCurricularViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
