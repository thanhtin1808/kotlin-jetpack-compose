package com.example.compose_ui_demo

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Composable
fun DemoListActivity(navController: NavHostController) {

    // Snackbar and Drawer
    val showNewActivity = mutableStateOf(false)
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
                if (showNewActivity.value) {
                    ShowWebView()
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Add a single item
                    item {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable { showNewActivity.value = true }
                        ) {
                            Text(text = "Download APP",
                                color = Color.Red,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold)
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



@Composable
fun ShowWebView() {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://app.kzingdemo.com/"))
    val context = LocalContext.current
    context.startActivity(intent)
}
