package com.example.deletebotton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Button99()
        }
    }
}

@Composable
fun Button99(modifier: Modifier = Modifier) {


    var isClicked by remember { mutableStateOf(false) }
    val iconSize by animateDpAsState(targetValue = if (isClicked) 40.dp else 24.dp)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { /*TODO*/
                isClicked=!isClicked
            },
            modifier = modifier.padding(16.dp).width(150.dp).height(70.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    modifier = Modifier.size(iconSize)
                )
                AnimatedVisibility(
                    visible = !isClicked,
                    enter = fadeIn(animationSpec = tween(1000)) + expandHorizontally(animationSpec = tween(1000)),
                    exit = fadeOut(animationSpec = tween(1000)) + shrinkHorizontally(animationSpec = tween(600))
                ) {
                    Text(text = "Delete", modifier = Modifier.padding(start = 16.dp))
                }

            }
        }


    }


}

@Preview(showSystemUi = true)
@Composable
private fun Hello() {
    Button99()

}
