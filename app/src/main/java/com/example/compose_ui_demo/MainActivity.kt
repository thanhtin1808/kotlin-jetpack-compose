package com.example.compose_ui_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_ui_demo.navigation.Routes
import com.example.compose_ui_demo.pages.HomePage
import com.example.compose_ui_demo.ui.theme.ComposeuidemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeuidemoTheme {
                ScreenMain()
            }
        }
    }
}

@Composable
fun ScreenMain() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomePage.route) {
        composable(Routes.HomePage.route) { HomePage(navController, "AAA") }
        composable(Routes.DemoListActivity.route) { DemoListActivity(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()

    ComposeuidemoTheme {
        HomePage(navController, "NEO")
    }
}