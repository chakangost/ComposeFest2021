package kr.co.freddie.composelayoutcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.co.freddie.composelayoutcodelab.ui.theme.ComposeLayoutCodelabTheme

class CustomLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutCodelabTheme {
                TextWithPaddingToBaselinePreview()

                TextWithNormalPaddingPreview()
            }
        }
    }

    @Composable
    fun CustomLayout(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
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

    private fun Modifier.firstBaselineToTop(
        firstBaselineToTop: Dp
    ) = this.then(
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            // Check the composable has a first baseline
            check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
            val firstBaseline = placeable[FirstBaseline]

            // Height of the composable with padding - first baseline
            val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
            val height = placeable.height + placeableY
            layout(placeable.width, height) {
                placeable.placeRelative(0, placeableY)
            }
        }
    )

    @Preview
    @Composable
    fun TextWithPaddingToBaselinePreview() {
        ComposeLayoutCodelabTheme {
            Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
        }
    }

    @Preview
    @Composable
    fun TextWithNormalPaddingPreview() {
        ComposeLayoutCodelabTheme {
            Text("Hi there!", Modifier.padding(top = 32.dp))
        }
    }
}