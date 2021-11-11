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
        Column(modifier = modifier.padding(8.dp)) {
            Text(text = "Hi there!")
            Text(text = "Thanks for your kind in the Compose code Lab")
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