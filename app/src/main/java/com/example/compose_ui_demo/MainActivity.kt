package com.example.compose_ui_demo

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_ui_demo.ui.theme.ComposeuidemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeuidemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Compose UI")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo Compose")
                }
            )
        },
        content = {
            Column {
                LinearLayoutBox(name = name)
                HorizontalLinearLayoutBox(name = name)
                RelativeLayoutBox(name = name)
                WeightBox()
            }
        },
        bottomBar = {
            BottomAppBar(
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
                            Text(text = "BBBB")
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeuidemoTheme {
        Greeting("NEO")
    }
}