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
import androidx.compose.ui.graphics.Color
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

@Composable
fun ColumnScope.CustomItem(weight: Float,color: Color = MaterialTheme.colors.primary){
    Surface(
        modifier = Modifier
            .weight(weight)
            .width(100.dp),
        color = color) {
    }
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
                CustomItem(1f,MaterialTheme.colors.secondary)
                CustomItem(1f,MaterialTheme.colors.primary)
            }
        }

    }
}