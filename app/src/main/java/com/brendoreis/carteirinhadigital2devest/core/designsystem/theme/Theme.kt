package com.brendoreis.carteirinhadigital2devest.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = RedPrimary,
    onPrimary = White,
    primaryContainer = RedSoft,
    onPrimaryContainer = RedDark,
    secondary = Ink,
    onSecondary = White,
    secondaryContainer = SurfaceContainer,
    onSecondaryContainer = Ink,
    background = Canvas,
    onBackground = Ink,
    surface = White,
    onSurface = Ink,
    surfaceVariant = SurfaceContainer,
    onSurfaceVariant = MutedInk,
    outline = Line,
    outlineVariant = Line,
    error = RedDark,
    onError = White
)

private val DarkColorScheme = darkColorScheme(
    primary = RedDarkMode,
    onPrimary = DarkCanvas,
    primaryContainer = RedDark,
    onPrimaryContainer = RedSoft,
    secondary = DarkInk,
    onSecondary = DarkCanvas,
    secondaryContainer = DarkSurfaceHigh,
    onSecondaryContainer = DarkInk,
    background = DarkCanvas,
    onBackground = DarkInk,
    surface = DarkSurface,
    onSurface = DarkInk,
    surfaceVariant = DarkSurfaceHigh,
    onSurfaceVariant = DarkMutedInk,
    outline = DarkLine,
    outlineVariant = DarkLine,
    error = RedDarkMode,
    onError = DarkCanvas
)

@Composable
fun CarteirinhaDigital2DEVESTTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = AppTypography,
        content = content
    )
}
