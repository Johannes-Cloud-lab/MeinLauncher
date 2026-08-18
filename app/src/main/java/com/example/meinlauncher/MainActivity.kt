package com.example.meinlauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AppItem(val label: String, val packageName: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val installedApps = getInstalledApps()

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppList(apps = installedApps) { packageName ->
                    launchApp(packageName)
                }
            }
        }
    }

    private fun getInstalledApps(): List<AppItem> {
        val mainIntent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }
        val apps = packageManager.queryIntentActivities(mainIntent, 0)
        return apps.map { resolveInfo ->
            AppItem(
                label = resolveInfo.loadLabel(packageManager).toString(),
                packageName = resolveInfo.activityInfo.packageName
            )
        }.sortedBy { it.label.lowercase() }
    }

    private fun launchApp(packageName: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            startActivity(intent)
        }
    }
}

@Composable
fun AppList(apps: List<AppItem>, onAppClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(apps) { app ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAppClick(app.packageName) }
                    .padding(vertical = 12.dp)
            ) {
                Text(
                    text = app.label,
                    fontSize = 18.sp
                )
            }
        }
    }
}
