package com.example.nativelauncher.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
        secondary = PurpleGrey80,
            background = DarkBackground,
                surface = Color(0x401E1E2C)
                )

                private val LightColorScheme = lightColorScheme(
                    primary = Purple80,
                        secondary = PurpleGrey80,
                            background = LightBackground,
                                surface = Color(0x80FFFFFF)
                                )

                                @Composable
                                fun NativeLauncherTheme(
                                    darkTheme: Boolean = true,
                                        content: @Composable () -> Unit
                                        ) {
                                            val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

                                                MaterialTheme(
                                                        colorScheme = colorScheme,
                                                                content = content
                                                                    )
                                                                    }
                                                                    