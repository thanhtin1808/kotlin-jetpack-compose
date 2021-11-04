package com.example.compose_ui_demo.navigation

// It contains route names to all three screens
sealed class Routes(val route: String) {
    object HomePage : Routes("home")
    object DemoListActivity : Routes("demo_list")
}
