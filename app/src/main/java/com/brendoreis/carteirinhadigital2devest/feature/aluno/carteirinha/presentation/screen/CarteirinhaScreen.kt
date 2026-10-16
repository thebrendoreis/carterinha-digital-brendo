package com.brendoreis.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brendoreis.carteirinhadigital2devest.R
import com.brendoreis.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.component.PerfilAluno
import com.brendoreis.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.component.QrCode
import com.brendoreis.carteirinhadigital2devest.feature.login.domain.model.UsuarioLogado

@Composable
fun CarteirinhaScreen(usuarioLogado: UsuarioLogado, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().padding(horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .widthIn(max = 520.dp)
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(18.dp))
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "Logo institucional",
                        modifier = Modifier.fillMaxWidth(0.64f).align(Alignment.Center)
                    )
                }
                Text("CARTEIRINHA DIGITAL", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                PerfilAluno(
                    nome = usuarioLogado.nome,
                    matricula = usuarioLogado.matricula,
                    curso = usuarioLogado.curso
                )
                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(12.dp)
                ) {
                    QrCode(
                        conteudo = usuarioLogado.matricula,
                        modifier = Modifier.size(156.dp)
                    )
                }
                Text(
                    "Apresente este código para identificação.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
