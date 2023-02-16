package com.example.jetpackcomposesampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleproject.ui.theme.JetpackComposeSampleProjectTheme
import com.example.jetpackcomposesampleproject.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleProjectTheme {
                Column(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CustomText(text: String){
   Text(
       text = "$text",
       style = Typography.h1
   )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleProjectTheme {
        Row (modifier = Modifier.fillMaxSize()){
            Column(
                modifier = Modifier.fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primaryVariant)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondaryVariant)) {
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primaryVariant)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondaryVariant)) {
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondary)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.primaryVariant)) {
                }
                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),
                    color = (MaterialTheme.colors.secondaryVariant)) {
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    modifier = Modifier
                        .width(200.dp).weight(2f),
                    color = (MaterialTheme.colors.primary)) {
                }
                Surface(
                    modifier = Modifier
                        .width(200.dp).weight(2f),
                    color = (MaterialTheme.colors.secondary)) {
                }
                Surface(
                    modifier = Modifier
                        .width(200.dp).weight(2f),
                    color = (MaterialTheme.colors.primaryVariant)) {
                }
                Surface(
                    modifier = Modifier
                        .width(200.dp).weight(1f),
                    color = (MaterialTheme.colors.secondaryVariant)) {
                }
            }
        }

    }
}