package com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.brendoreis.carteirinhadigital2devest.feature.professor.unidadescurriculares.domain.model.ProfessorUnidadeCurricular

@Composable
fun ProfessorUnidadeCurricularCard(
    unidade: ProfessorUnidadeCurricular,
    modifier: Modifier = Modifier
) {
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
            Text(unidade.nome, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurface)
            Text("Turma  •  ${unidade.turma}", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Carga horária", style = MaterialTheme.typography.bodyMedium)
                Text("${unidade.cargaHoraria} h", style = MaterialTheme.typography.labelLarge)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Aulas realizadas", style = MaterialTheme.typography.bodyMedium)
                Text("${unidade.aulasRealizadas} de ${unidade.quantidadeAulas}", style = MaterialTheme.typography.labelLarge)
            }
            Text(
                "${unidade.diasSemana.joinToString(", ")}  •  ${unidade.horarioInicio}–${unidade.horarioFim}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
