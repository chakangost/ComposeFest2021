package kr.co.freddie.composelayoutcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.freddie.composelayoutcodelab.ui.theme.ComposeLayoutCodelabTheme

class ScaffoldActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutCodelabTheme {
                LayoutsCodeLab()
            }
        }
    }

    @Composable
    fun LayoutsCodeLab() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Freddie Kingdom")
                    },
                    actions = {
                        IconButton(
                            onClick = { /*doSometing*/ }, modifier = Modifier
                                .size(30.dp, 30.dp)
                                .padding(4.dp)
                        )
                        {
                            Icon(Icons.Filled.BrokenImage, contentDescription = null)
                        }
                        IconButton(
                            onClick = { /*doSometing*/ },
                            modifier = Modifier
                                .size(30.dp, 30.dp)
                                .padding(4.dp)
                        ) {
                            Icon(Icons.Filled.East, contentDescription = null)
                        }
                        IconButton(
                            onClick = { /*doSometing*/ },
                            modifier = Modifier
                                .size(30.dp, 30.dp)
                                .padding(4.dp)
                        ) {
                            Icon(Icons.Filled.Album, contentDescription = null)
                        }
                        IconButton(
                            onClick = { /*doSometing*/ },
                            modifier = Modifier
                                .size(40.dp, 40.dp)
                                .padding(4.dp)
                                .absolutePadding(0.dp, 0.dp, 10.dp, 0.dp)
                        ) {
                            Icon(Icons.Filled.Cabin, contentDescription = null)
                        }
                    }
                )
            }
        ) { innerPadding ->
            BodyContent(Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        CustomLayout(modifier.padding(8.dp)) {
            Text("MyOwnColumn")
            Text("places items")
            Text("vertically.")
            Text("We've done it by hand!")
        }
    }

    @Composable
    private fun CustomLayout(modifier: Modifier, content: @Composable () -> Unit) {
        Layout(
            modifier = modifier,
            content = content
        ) { measurables, constraints ->
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            var yPosition = 0

            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    }

    @Preview
    @Composable
    fun LayoutsCodeLabPreview() {
        ComposeLayoutCodelabTheme {
            LayoutsCodeLab()
        }
    }
}