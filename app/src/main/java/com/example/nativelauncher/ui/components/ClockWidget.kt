package com.example.nativelauncher.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ClockWidget() {
    var timeString by remember { mutableStateOf("") }
        var dateString by remember { mutableStateOf("") }

            LaunchedEffect(Unit) {
                    while (true) {
                                val now = Date()
                                            timeString = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)
                                                        dateString = SimpleDateFormat("EEEE, d. MMMM", Locale.GERMAN).format(now)
                                                                    delay(1000)
                                                                            }
                                                                                }

                                                                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                                                            Text(
                                                                                                        text = timeString,
                                                                                                                    fontSize = 72.sp,
                                                                                                                                fontWeight = FontWeight.Thin,
                                                                                                                                            color = Color.White
                                                                                                                                                    )
                                                                                                                                                            Text(
                                                                                                                                                                        text = dateString,
                                                                                                                                                                                    fontSize = 18.sp,
                                                                                                                                                                                                fontWeight = FontWeight.Normal,
                                                                                                                                                                                                            color = Color.White.copy(alpha = 0.8f)
                                                                                                                                                                                                                    )
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        