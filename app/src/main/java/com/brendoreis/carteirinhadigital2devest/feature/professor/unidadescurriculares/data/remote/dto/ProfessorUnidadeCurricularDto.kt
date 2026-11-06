package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.data.remote.dto

import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.model.ProfessorUnidadeCurricular
import kotlinx.serialization.Serializable

@Serializable
data class ProfessorUnidadeCurricularDto(
    val id: String,
    val nome: String,
    val turmaId: String,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain() = ProfessorUnidadeCurricular(
        id = id,
        nome = nome,
        turmaId = turmaId,
        turma = turma,
        cargaHoraria = cargaHoraria,
        quantidadeAulas = quantidadeAulas,
        aulasRealizadas = aulasRealizadas,
        diasSemana = diasSemana,
        horarioInicio = horarioInicio,
        horarioFim = horarioFim
    )
}
