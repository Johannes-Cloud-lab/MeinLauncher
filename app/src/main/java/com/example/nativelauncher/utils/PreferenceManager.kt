package com.example.nativelauncher.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
            context.getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE)

                var gridColumns: Int
                        get() = prefs.getInt("grid_columns", 4)
                                set(value) = prefs.edit().putInt("grid_columns", value).apply()

                                    var showLabels: Boolean
                                            get() = prefs.getBoolean("show_labels", true)
                                                    set(value) = prefs.edit().putBoolean("show_labels", value).apply()

                                                        var isDarkMode: Boolean
                                                                get() = prefs.getBoolean("dark_mode", true)
                                                                        set(value) = prefs.edit().putBoolean("dark_mode", value).apply()

                                                                            var iconSizeDp: Int
                                                                                    get() = prefs.getInt("icon_size", 56)
                                                                                            set(value) = prefs.edit().putInt("icon_size", value).apply()
                                                                                            }
                                                                                            