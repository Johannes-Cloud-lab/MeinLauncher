package com.example.nativelauncher.model

import android.graphics.drawable.Drawable

data class AppInfo(
    val label: String,
        val packageName: String,
            val icon: Drawable,
                val className: String
                )
                