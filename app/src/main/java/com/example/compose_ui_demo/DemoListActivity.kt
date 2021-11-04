package com.example.compose_ui_demo

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_demo.navigation.Routes
import com.example.compose_ui_demo.ui.theme.ComposeuidemoTheme
import kotlinx.coroutines.launch

@Composable
fun DemoListActivity(navController: NavHostController) {

    // Snackbar and Drawer
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            navController.popBackStack()
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), contentAlignment = Alignment.Center
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Add a single item
                    item {
                        Box(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "First item")
                        }
                    }

                    // Add 5 items
                    items(100) { index ->
                        Box(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Item: $index")
                        }
                    }

                    // Add another single item
                    item {
                        Box(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Last item")
                        }
                    }
                }
            }
        }
    )
}