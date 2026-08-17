package com.example.nativelauncher.repository

import android.content.Context
import android.content.Intent
import com.example.nativelauncher.model.AppInfo

class AppRepository(private val context: Context) {

    fun getInstalledApps(): List<AppInfo> {
            val packageManager = context.packageManager
                    val intent = Intent(Intent.ACTION_MAIN, null).apply {
                                addCategory(Intent.CATEGORY_LAUNCHER)
                                        }

                                                val resolveInfoList = packageManager.queryIntentActivities(intent, 0)
                                                        val apps = mutableListOf<AppInfo>()

                                                                for (resolveInfo in resolveInfoList) {
                                                                            // Eigenen Launcher aus der App-Liste filtern
                                                                                        if (resolveInfo.activityInfo.packageName == context.packageName) continue

                                                                                                    val label = resolveInfo.loadLabel(packageManager).toString()
                                                                                                                val packageName = resolveInfo.activityInfo.packageName
                                                                                                                            val className = resolveInfo.activityInfo.name
                                                                                                                                        val icon = resolveInfo.loadIcon(packageManager)

                                                                                                                                                    apps.add(AppInfo(label, packageName, icon, className))
                                                                                                                                                            }

                                                                                                                                                                    return apps.sortedBy { it.label.lowercase() }
                                                                                                                                                                        }
                                                                                                                                                                        }
                                                                                                                                                                        