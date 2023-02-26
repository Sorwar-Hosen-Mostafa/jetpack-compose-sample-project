package com.example.jetpackcomposesampleproject

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleproject.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SocialLoginButton(
    text: String,
    icon: Int,
    loadingText: String = "Creating Account...",
    shapes: Shape = Shapes.medium,
    textColor: Color = Color.Black,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onclicked: () -> Unit
) {
    var clicked by remember {
        mutableStateOf(false)
    }

    Surface(
        shape = shapes,
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        ),
        color = backgroundColor,
        onClick = { clicked = !clicked }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
        ) {
            Icon(
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = if (clicked) loadingText else text,
                color = textColor
            )

            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onclicked()
            }
        }
    }
}

@Preview
@Composable
fun GoogleButtonPreview() {
    SocialLoginButton(
        text = "Sign Up with Google",
        icon = R.drawable.ic_google_icon
    ) {

    }
}