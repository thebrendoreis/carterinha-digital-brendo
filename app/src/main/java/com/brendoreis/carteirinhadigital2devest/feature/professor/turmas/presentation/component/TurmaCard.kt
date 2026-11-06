package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.domain.model.Turma

@Composable
fun TurmaCard(turma: Turma, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(turma.codigo, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurface)
            Text(turma.curso, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("Semestre  •  ${turma.semestre}", style = MaterialTheme.typography.bodyMedium)
            Text("Alunos  •  ${turma.quantidadeAlunos}", style = MaterialTheme.typography.bodyMedium)
            Text(
                "${turma.diasSemana.toDiasPt()}  •  ${turma.horarioInicio}–${turma.horarioFim}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

internal fun List<String>.toDiasPt(): String = joinToString(" • ") { dia ->
    when (dia.uppercase()) {
        "SEGUNDA" -> "Segunda-feira"
        "TERCA", "TERÇA" -> "Terça-feira"
        "QUARTA" -> "Quarta-feira"
        "QUINTA" -> "Quinta-feira"
        "SEXTA" -> "Sexta-feira"
        "SABADO", "SÁBADO" -> "Sábado"
        "DOMINGO" -> "Domingo"
        else -> dia.lowercase().replaceFirstChar { it.titlecase() }
    }
}
