package com.example.compose_ui_demo

import android.app.Activity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun WebViewActivity(): Activity {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo WebView")
                }
            )
        }, content = {}
    )
    return WebViewActivity()
}