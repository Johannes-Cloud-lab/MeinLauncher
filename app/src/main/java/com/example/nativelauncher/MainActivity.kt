package com.example.nativelauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import com.example.nativelauncher.ui.components.AppOptionsDialog
import com.example.nativelauncher.ui.screens.AppDrawerScreen
import com.example.nativelauncher.ui.screens.HomeScreen
import com.example.nativelauncher.ui.screens.SettingsScreen
import com.example.nativelauncher.ui.theme.NativeLauncherTheme
import com.example.nativelauncher.viewmodel.LauncherScreen
import com.example.nativelauncher.viewmodel.LauncherViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: LauncherViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
                                    override fun handleOnBackPressed() {
                                                    if (viewModel.currentScreen != LauncherScreen.HOME) {
                                                                        viewModel.currentScreen = LauncherScreen.HOME
                                                                                        }
                                                                                                    }
                                                                                                            })

                                                                                                                    setContent {
                                                                                                                                NativeLauncherTheme(darkTheme = viewModel.isDarkModeState) {
                                                                                                                                                Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                                                                                                                                                                    when (viewModel.currentScreen) {
                                                                                                                                                                                            LauncherScreen.HOME -> HomeScreen(viewModel = viewModel)
                                                                                                                                                                                                                    LauncherScreen.DRAWER -> AppDrawerScreen(viewModel = viewModel)
                                                                                                                                                                                                                                            LauncherScreen.SETTINGS -> SettingsScreen(viewModel = viewModel)
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                    viewModel.selectedAppForMenu?.let { app ->
                                                                                                                                                                                                                                                                                                            AppOptionsDialog(
                                                                                                                                                                                                                                                                                                                                        app = app,
                                                                                                                                                                                                                                                                                                                                                                    onDismiss = { viewModel.selectedAppForMenu = null },
                                                                                                                                                                                                                                                                                                                                                                                                onAppInfo = { viewModel.openAppDetails(app) },
                                                                                                                                                                                                                                                                                                                                                                                                                            onUninstall = { viewModel.uninstallApp(app) }
                                                                                                                                                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    override fun onResume() {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            super.onResume()
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    viewModel.loadApps()
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        