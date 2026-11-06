package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.repository

import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.model.Turma


interface TurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}
