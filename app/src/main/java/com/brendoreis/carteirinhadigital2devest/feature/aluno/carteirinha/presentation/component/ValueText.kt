package com.brendoreis.carteirinhadigital2devest.feature.aluno.carteirinha.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ValueText(modifier: Modifier = Modifier, text: String, fontWeight: FontWeight = FontWeight.SemiBold) {
    Text(text = text, style = MaterialTheme.typography.titleMedium, fontWeight = fontWeight, modifier = modifier)
}
