package com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.TurmaViewModel
import com.brendoreis.carteirinhadigital2devest.feature.professor.turmas.presentation.component.TurmaCard


@Composable
fun TurmasProfessorScreen(viewModel: TurmaViewModel, modifier: Modifier = Modifier) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(viewModel) { viewModel.carregar() }

    when {
        state.isLoading -> Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        state.errorMessage != null -> Column(
            modifier = modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(state.errorMessage.orEmpty(), color = MaterialTheme.colorScheme.error)
            Button(onClick = viewModel::carregar, modifier = Modifier.padding(top = 16.dp)) {
                Text("Tentar novamente")
            }
        }
        state.turmas.isEmpty() -> Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Nenhuma turma encontrada.")
        }
        else -> LazyColumn(
            modifier = modifier.fillMaxSize().widthIn(max = 720.dp).padding(horizontal = 20.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(state.turmas, key = { it.id }) { turma -> TurmaCard(turma) }
        }
    }
}
