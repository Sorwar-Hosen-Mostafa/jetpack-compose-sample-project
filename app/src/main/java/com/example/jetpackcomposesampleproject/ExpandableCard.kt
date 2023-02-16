package com.example.jetpackcomposesampleproject

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    title: String,
    body: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h3.fontSize,
    bodyFontSize: TextUnit = MaterialTheme.typography.body1.fontSize,
    animDuration: Int = 300
) {
    var expandedState by remember { mutableStateOf(true) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = animDuration, easing = LinearOutSlowInEasing
            )
        )
        .padding(10.dp), shape = MaterialTheme.shapes.medium, onClick = {

        expandedState = !expandedState
    }) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(10f),
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                IconButton(modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        modifier = Modifier.width(50.dp),
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-down Arrow"
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = body,
                    fontSize = bodyFontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )
            }
        }
    }
}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard("What is Lorem Ipsum?", stringResource(id = R.string.lorem_ipsum), titleFontSize = MaterialTheme.typography.h5.fontSize, bodyFontSize = MaterialTheme.typography.body2.fontSize, 1000)
}
