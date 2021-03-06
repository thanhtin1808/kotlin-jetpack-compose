package com.example.compose_ui_demo.pages

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_demo.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun HomePage(navController: NavHostController, name: String) {

    var selectedTabIndex by remember { mutableStateOf(0) }

    // Snackbar and Drawer
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }) {
                        Icon(Icons.Default.Menu, "Menu")
                    }
                },
                actions = {
                    Button(onClick = {
                        Log.d("AAAAA", "ON CLICK")
                        navController.navigate(Routes.DemoListActivity.route)
                    }) {
                        Text(text = "Go to 2nd screen")
                    }
                }
            )
        },
        drawerContent = {
            Text("Drawer title", modifier = Modifier.padding(16.dp))
            Divider()
        },
        content = {
            Column {
                LinearLayoutBox(name = name)
                HorizontalLinearLayoutBox(name = name)
                RelativeLayoutBox(name = name)
                WeightBox()
            }
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                scope.launch {
//                    scaffoldState.snackbarHostState.showSnackbar("Snackbar")
//                }
//            }) {
//
//            }
//        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                ),
                content = {
                    TabRow(selectedTabIndex = selectedTabIndex) {
                        Tab(selected = selectedTabIndex == 0, onClick = {
                            selectedTabIndex = 0
                            Log.d("AAAA", "Click 1")
                        }) {
                            Text(text = "AAAA")
                        }
                        Tab(selected = selectedTabIndex == 1, onClick = {
                            selectedTabIndex = 1
                            Log.d("AAAA", "Click 2")
                        }) {
                            Text(text = "HOME")
                        }
                        Tab(selected = selectedTabIndex == 2, onClick = {
                            selectedTabIndex = 2
                            Log.d("AAAA", "Click 3")
                        }) {
                            Text(text = "CCCC")
                        }
                    }
                }
            )
        }
    )

}

@Composable
fun LinearLayoutBox(name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "LinearLayout liked $name!")
        RoundedCornerShapeDemo(shape = RoundedCornerShape(10.dp))
    }
}

@Composable
fun HorizontalLinearLayoutBox(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "LinearLayout (Horizontal) liked $name!")
        RoundedCornerShapeDemo(shape = RoundedCornerShape(10.dp))
    }
}

@Composable
fun RelativeLayoutBox(name: String) {
    Box() {
        // This = fill_parent
//        Spacer(Modifier.fillMaxSize().background(Color.LightGray))
        // This = wrap_content
        Spacer(
            Modifier
                .matchParentSize()
                .background(Color.LightGray)
        )
        RoundedCornerShapeDemo(shape = RoundedCornerShape(10.dp))
        Text(
            text = "RelativeLayout liked $name!",
            modifier = Modifier.paddingFromBaseline(top = 30.dp)
        )
    }
}

@Composable
fun WeightBox() {
    Row() {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
        ) {
            RoundedCornerShapeDemo(
                shape = RoundedCornerShape(10.dp)
            )
            Text(
                text = "Weight 1",
                modifier = Modifier.padding(
                    top = 30.dp,
                    start = 10.dp
                )
            )
        }
        Box(modifier = Modifier.weight(2f)) {
            RoundedCornerShapeDemo(
                shape = RoundedCornerShape(10.dp),
            )
            Text(
                text = "Weight 2",
                modifier = Modifier.padding(
                    top = 30.dp,
                    start = 10.dp
                )
            )
        }
    }
}

@Composable
fun RoundedCornerShapeDemo(shape: Shape) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}