package com.example.nativelauncher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nativelauncher.ui.components.AppIconItem
import com.example.nativelauncher.viewmodel.LauncherViewModel

@Composable
fun AppDrawerScreen(viewModel: LauncherViewModel) {
    Column(
            modifier = Modifier
                        .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.85f))
                                                .statusBarsPadding()
                                                            .navigationBarsPadding()
                                                                        .padding(horizontal = 16.dp)
                                                                            ) {
                                                                                    Spacer(modifier = Modifier.height(16.dp))

                                                                                            OutlinedTextField(
                                                                                                        value = viewModel.searchQuery,
                                                                                                                    onValueChange = { viewModel.searchQuery = it },
                                                                                                                                placeholder = { Text("Apps durchsuchen...", color = Color.Gray) },
                                                                                                                                            singleLine = true,
                                                                                                                                                        shape = RoundedCornerShape(24.dp),
                                                                                                                                                                    colors = OutlinedTextFieldDefaults.colors(
                                                                                                                                                                                    focusedBorderColor = Color.White,
                                                                                                                                                                                                    unfocusedBorderColor = Color.Gray,
                                                                                                                                                                                                                    focusedTextColor = Color.White,
                                                                                                                                                                                                                                    unfocusedTextColor = Color.White
                                                                                                                                                                                                                                                ),
                                                                                                                                                                                                                                                            modifier = Modifier.fillMaxWidth()
                                                                                                                                                                                                                                                                    )

                                                                                                                                                                                                                                                                            Spacer(modifier = Modifier.height(16.dp))

                                                                                                                                                                                                                                                                                    LazyVerticalGrid(
                                                                                                                                                                                                                                                                                                columns = GridCells.Fixed(viewModel.gridColumnsState),
                                                                                                                                                                                                                                                                                                            modifier = Modifier.fillMaxSize(),
                                                                                                                                                                                                                                                                                                                        contentPadding = PaddingValues(bottom = 16.dp)
                                                                                                                                                                                                                                                                                                                                ) {
                                                                                                                                                                                                                                                                                                                                            items(viewModel.filteredApps) { app ->
                                                                                                                                                                                                                                                                                                                                                            AppIconItem(
                                                                                                                                                                                                                                                                                                                                                                                app = app,
                                                                                                                                                                                                                                                                                                                                                                                                    showLabel = viewModel.showLabelsState,
                                                                                                                                                                                                                                                                                                                                                                                                                        iconSizeDp = viewModel.iconSizeState,
                                                                                                                                                                                                                                                                                                                                                                                                                                            onClick = { viewModel.launchApp(app) },
                                                                                                                                                                                                                                                                                                                                                                                                                                                                onLongClick = { viewModel.selectedAppForMenu = app }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        