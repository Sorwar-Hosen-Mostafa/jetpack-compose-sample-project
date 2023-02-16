package com.example.jetpackcomposesampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleproject.ui.theme.JetpackComposeSampleProjectTheme
import com.example.jetpackcomposesampleproject.ui.theme.Shapes
import com.example.jetpackcomposesampleproject.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleProjectTheme {
                //RowAndColumn()
                //Boxes()
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background)) {
                    TextCustomization()
                }

            }
        }
    }
}

@Composable
fun TextCustomization(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary)
                .padding(16.dp),
            text = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun RowAndColumn() {
    Row (modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f,MaterialTheme.colors.secondary)
            CustomItem(1f,MaterialTheme.colors.primary)
            CustomItem(1f,MaterialTheme.colors.secondary)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f,MaterialTheme.colors.primary)
            CustomItem(1f,MaterialTheme.colors.secondary)
            CustomItem(1f,MaterialTheme.colors.primary)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f,MaterialTheme.colors.secondary)
            CustomItem(1f,MaterialTheme.colors.primary)
            CustomItem(1f,MaterialTheme.colors.secondary)
        }
    }
}

@Composable
fun Boxes() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), contentAlignment = Alignment.Center){
            Box(modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(
                    color = MaterialTheme.colors.secondaryVariant,
                    shape = Shapes.medium
                )
                .verticalScroll(rememberScrollState())
            ){
                Text(text = "Hello World, Whats up!!",
                    style = Typography.h1
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), contentAlignment = Alignment.Center){
            Box(modifier = Modifier
                .background(
                    color= MaterialTheme.colors.background,
                    shape = Shapes.medium
                )
            ){
                Text(text = "Hello World",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }


}


@Composable
fun ColumnScope.CustomItem(weight: Float,color: Color = MaterialTheme.colors.primary){
    Surface(
        modifier = Modifier
            .weight(weight)
            .fillMaxWidth(),
        color = color) {
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleProjectTheme {
        TextCustomization()
    }
}

/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleProjectTheme {
            Boxes()
    }
}*/

/*
@Preview(showBackground = true)
@Composable
fun CustomPreview(){
    JetpackComposeSampleProjectTheme {
        RowAndColumn()
    }
}*/
