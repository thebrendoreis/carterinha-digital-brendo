package com.brendoreis.carteirinhadigital2devest.feature.professor.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brendoreis.carteirinhadigital2devest.core.designsystem.component.NavigationButton
import com.brendoreis.carteirinhadigital2devest.core.designsystem.theme.CarteirinhaDigital2DEVESTTheme
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.model.PerfilAcesso
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.model.UsuarioLogado

@Composable
fun HomeProfessorScreen(
    usuarioLogado: UsuarioLogado,
    onTurmasClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 28.dp),
        verticalArrangement =
            Arrangement.spacedBy(20.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, ${usuarioLogado.nome.substringBefore(' ')}",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth()
        )

        Text(
            text = "Acompanhe suas atividades acadêmicas.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth()
        )

        Card(
            modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Professor",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = "Matrícula  •  ${usuarioLogado.matricula}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Text(
                    text = "Acesse suas turmas e unidades curriculares.",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        NavigationButton(
            text = "Minhas Turmas",
            onClick = onTurmasClick,
            modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth()
        )

        NavigationButton(
            text = "Unidades Curriculares",
            onClick = onUnidadesCurricularesClick,
            modifier = Modifier.widthIn(max = 560.dp).fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeProfessorPreview() {
    CarteirinhaDigital2DEVESTTheme {
        HomeProfessorScreen(
            usuarioLogado = UsuarioLogado(
                id = "2",
                nome = "Professor Modelo",
                matricula = "PROF20260001",
                perfil = PerfilAcesso.PROFESSOR,
                curso = "",
                turma = "",
                token = "token"
            ),
            onTurmasClick = {},
            onUnidadesCurricularesClick = {}
        )
    }
}
