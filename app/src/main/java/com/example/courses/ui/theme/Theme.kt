package com.example.courses.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = primary_dark,
    secondary = secondary_dark,
    tertiary = tertiary_dark
)
private val LightColors = lightColorScheme(
    primary = primary_light,
    secondary = secondary_light,
    tertiary = tertiary_light
)

@Composable
fun CoursesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}
