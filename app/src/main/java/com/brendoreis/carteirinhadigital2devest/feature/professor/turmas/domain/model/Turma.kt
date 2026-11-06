package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.model

data class Turma(
    val id: String,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)
