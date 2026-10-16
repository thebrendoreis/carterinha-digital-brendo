package com.brendoreis.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brendoreis.carteirinhadigital2devest.R

@Composable
fun PerfilAluno(nome: String, matricula: String, curso: String, idFoto: Int = R.drawable.login) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(idFoto),
            contentDescription = "Foto do aluno",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(112.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(3.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(24.dp))
        )
        InfoAluno(label = "Nome", value = nome)
        InfoAluno(label = "Matrícula", value = matricula)
        InfoAluno(label = "Curso", value = curso)
    }
}
