package com.example.nativelauncher.ui.components

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nativelauncher.model.AppInfo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppIconItem(
    app: AppInfo,
        showLabel: Boolean,
            iconSizeDp: Int,
                onClick: () -> Unit,
                    onLongClick: () -> Unit
                    ) {
                        val bitmap = remember(app.packageName) {
                                drawableToBitmap(app.icon)
                                    }

                                        Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                        modifier = Modifier
                                                                    .padding(8.dp)
                                                                                .combinedClickable(
                                                                                                onClick = onClick,
                                                                                                                onLongClick = onLongClick
                                                                                                                            )
                                                                                                                                ) {
                                                                                                                                        Image(
                                                                                                                                                    bitmap = bitmap,
                                                                                                                                                                contentDescription = app.label,
                                                                                                                                                                            modifier = Modifier.size(iconSizeDp.dp)
                                                                                                                                                                                    )
                                                                                                                                                                                            if (showLabel) {
                                                                                                                                                                                                        Spacer(modifier = Modifier.height(4.dp))
                                                                                                                                                                                                                    Text(
                                                                                                                                                                                                                                    text = app.label,
                                                                                                                                                                                                                                                    color = Color.White,
                                                                                                                                                                                                                                                                    fontSize = 12.sp,
                                                                                                                                                                                                                                                                                    maxLines = 1,
                                                                                                                                                                                                                                                                                                    overflow = TextOverflow.Ellipsis,
                                                                                                                                                                                                                                                                                                                    textAlign = TextAlign.Center,
                                                                                                                                                                                                                                                                                                                                    modifier = Modifier.fillMaxWidth()
                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                            private fun drawableToBitmap(drawable: Drawable): ImageBitmap {
                                                                                                                                                                                                                                                                                                                                                                val width = if (drawable.intrinsicWidth > 0) drawable.intrinsicWidth else 96
                                                                                                                                                                                                                                                                                                                                                                    val height = if (drawable.intrinsicHeight > 0) drawable.intrinsicHeight else 96
                                                                                                                                                                                                                                                                                                                                                                        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                                                                                                                                                                                                                                                                                                                                                                            val canvas = Canvas(bitmap)
                                                                                                                                                                                                                                                                                                                                                                                drawable.setBounds(0, 0, canvas.width, canvas.height)
                                                                                                                                                                                                                                                                                                                                                                                    drawable.draw(canvas)
                                                                                                                                                                                                                                                                                                                                                                                        return bitmap.asImageBitmap()
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                        