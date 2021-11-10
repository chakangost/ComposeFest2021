package kr.co.freddie.composelayoutcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kr.co.freddie.composelayoutcodelab.ui.theme.ComposeLayoutCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutCodelabTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PhotographerCard()
                }
            }
        }
    }
}

@Composable
fun PhotographerCard() {
    Column {
        Text("Alfred Sisley", fontWeight = FontWeight.Bold)

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    ComposeLayoutCodelabTheme {
        PhotographerCard()
    }
}