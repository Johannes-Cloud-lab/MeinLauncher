package com.example.nativelauncher.viewmodel

import android.app.Application
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.nativelauncher.model.AppInfo
import com.example.nativelauncher.repository.AppRepository
import com.example.nativelauncher.utils.PreferenceManager

enum class LauncherScreen {
    HOME, DRAWER, SETTINGS
    }

    class LauncherViewModel(application: Application) : AndroidViewModel(application) {

        private val repository = AppRepository(application)
            val prefs = PreferenceManager(application)

                var installedApps by mutableStateOf<List<AppInfo>>(emptyList())
                        private set

                            var searchQuery by mutableStateOf("")
                                var currentScreen by mutableStateOf(LauncherScreen.HOME)
                                    var selectedAppForMenu by mutableStateOf<AppInfo?>(null)

                                        var gridColumnsState by mutableStateOf(prefs.gridColumns)
                                            var showLabelsState by mutableStateOf(prefs.showLabels)
                                                var isDarkModeState by mutableStateOf(prefs.isDarkMode)
                                                    var iconSizeState by mutableStateOf(prefs.iconSizeDp)

                                                        init {
                                                                loadApps()
                                                                    }

                                                                        fun loadApps() {
                                                                                installedApps = repository.getInstalledApps()
                                                                                    }

                                                                                        val filteredApps: List<AppInfo>
                                                                                                get() = if (searchQuery.isEmpty()) {
                                                                                                            installedApps
                                                                                                                    } else {
                                                                                                                                installedApps.filter { it.label.contains(searchQuery, ignoreCase = true) }
                                                                                                                                        }

                                                                                                                                            fun launchApp(app: AppInfo) {
                                                                                                                                                    val context = getApplication<Application>()
                                                                                                                                                            val intent = Intent(Intent.ACTION_MAIN).apply {
                                                                                                                                                                        addCategory(Intent.CATEGORY_LAUNCHER)
                                                                                                                                                                                    component = ComponentName(app.packageName, app.className)
                                                                                                                                                                                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                                                                                                                                                                                                        }
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                            context.startActivity(intent)
                                                                                                                                                                                                                                    } catch (_: Exception) {}
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                            fun openAppDetails(app: AppInfo) {
                                                                                                                                                                                                                                                    val context = getApplication<Application>()
                                                                                                                                                                                                                                                            val intent = Intent(
                                                                                                                                                                                                                                                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                                                                                                                                                                                                                                                                    Uri.parse("package:${app.packageName}")
                                                                                                                                                                                                                                                                                            ).apply {
                                                                                                                                                                                                                                                                                                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                        context.startActivity(intent)
                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                fun uninstallApp(app: AppInfo) {
                                                                                                                                                                                                                                                                                                                                        val context = getApplication<Application>()
                                                                                                                                                                                                                                                                                                                                                val intent = Intent(
                                                                                                                                                                                                                                                                                                                                                            Intent.ACTION_UNINSTALL_PACKAGE,
                                                                                                                                                                                                                                                                                                                                                                        Uri.parse("package:${app.packageName}")
                                                                                                                                                                                                                                                                                                                                                                                ).apply {
                                                                                                                                                                                                                                                                                                                                                                                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                            context.startActivity(intent)
                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                    fun updateGridColumns(columns: Int) {
                                                                                                                                                                                                                                                                                                                                                                                                                            gridColumnsState = columns
                                                                                                                                                                                                                                                                                                                                                                                                                                    prefs.gridColumns = columns
                                                                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                                                            fun updateShowLabels(show: Boolean) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    showLabelsState = show
                                                                                                                                                                                                                                                                                                                                                                                                                                                            prefs.showLabels = show
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fun updateDarkMode(dark: Boolean) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            isDarkModeState = dark
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    prefs.isDarkMode = dark
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fun updateIconSize(sizeDp: Int) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    iconSizeState = sizeDp
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            prefs.iconSizeDp = sizeDp
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                