package com.example.jetpackcomposesampleproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.example.jetpackcomposesampleproject.ui.theme.JetpackComposeSampleProjectTheme
import com.example.jetpackcomposesampleproject.ui.theme.Shapes
import com.example.jetpackcomposesampleproject.ui.theme.Typography

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleProjectTheme {
                run()
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

private const val TAG = "MainActivity"

@Composable
fun run() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        CoilImage()


        // CustomButtons()
        // TextFieldSample()
        /*Column {
            ExpandableCard(title = "Lorem Ipsum", body = stringResource(id = R.string.lorem_ipsum))
        }*/
        /*Column {
            Script(normalText = "Hello", superText = "World", baselineShift = BaselineShift.Superscript)
            Script(normalText = "Hello", superText = "World", baselineShift = BaselineShift.Subscript)
        }*/
        //RowAndColumn()
        //Boxes()
        //TextCustomization()


    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.Center) {

            val painter = rememberImagePainter(
                data = "https://wallpapersafari.com/downloadres/kbNDEm/desktop/1920/1080/",
                builder = {
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(500)
                    transformations(
                        GrayscaleTransformation(),
                        RoundedCornersTransformation(100f)
                    )
                }
            )
            val painterState = painter.state
            Image(painter = painter, contentDescription = null)

            if (painterState is ImagePainter.State.Loading) {
                CircularProgressIndicator()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(contentAlignment = Alignment.Center) {

            val painter = rememberImagePainter(
                data = "https://wallpapersafari.com/downloadres/I09mLB/desktop/1920/1080/",
                builder = {
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(500)
                    transformations(
                        BlurTransformation(context = LocalContext.current),
                        CircleCropTransformation()
                    )
                }
            )
            val painterState = painter.state
            Image(painter = painter, contentDescription = null)

            if (painterState is ImagePainter.State.Loading) {
                CircularProgressIndicator()
            }
        }
    }

}

@Composable
fun CustomButtons() {
    SocialLoginButton(
        text = "Sign Up with Google",
        icon = R.drawable.ic_google_icon,
        textColor = Color.White,
        shapes = Shapes.large,
        backgroundColor = Color.DarkGray,
        progressIndicatorColor = Color.White
    ) {
        Log.e(TAG, "Creating google account....")
    }

    Spacer(modifier = Modifier.height(16.dp))

    SocialLoginButton(
        text = "Sign Up with Facebook",
        icon = R.drawable.ic_facebook,
        progressIndicatorColor = MaterialTheme.colors.secondary
    ) {
        Log.e(TAG, "Creating facebook account....")
    }

}

@Composable
fun TextFieldSample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        var value by remember { mutableStateOf("Type anything here...") }
        TextField(
            label = {
                Text(text = "this a label")
            },
            value = value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                println("text")
                value = it
            })

        BasicTextField(
            value = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(shape = Shapes.large, color = Color.LightGray)
                .padding(20.dp),
            onValueChange = {
                println("text")
                value = it
            })

        TextField(
            value = "this field is not enabled",
            enabled = false,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
            })

        TextField(
            value = "This is read only, we cannot modify but can select and copy",
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
            })

        var v1 by remember { mutableStateOf("Lerem ipsum, snd fjjskk ahgj ahdhg 9eihg dhhgks hghhgke ghhgks ghheighi sheh giehgh") }
        TextField(
            value = v1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                v1 = it
            })


        var v2 by remember { mutableStateOf("") }
        TextField(
            value = v2,
            singleLine = true,
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check Icon")
                }
            },
            onValueChange = {
                v2 = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                Log.e("Imei action", "on search Clicked")

            })


        )

        var v3 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = v3,
            singleLine = true,
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check Icon")
                }
            },
            onValueChange = {
                v3 = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                Log.e("Imei action", "on search Clicked")

            })


        )

    }
}

@Composable
fun Script(normalText: String, superText: String, baselineShift: BaselineShift) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.overline.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = baselineShift
            )
        ) {
            append(superText)
        }
    })
}


@Composable
fun TextCustomization() {
    SelectionContainer {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomText()
            DisableSelection {
                CustomText2()
            }
            CustomText3()
        }

    }

}

@Composable
fun CustomText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary)
                .fillMaxWidth()
                .padding(16.dp),
            text = stringResource(id = R.string.app_name),
            fontSize = 16.sp,
            color = MaterialTheme.colors.error,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun CustomText2() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {


                    withStyle(
                        style = SpanStyle(
                            fontStyle = FontStyle.Italic,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append("P")
                    }
                    append("Smart")


                }
            }, modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CustomText3() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            text = "Hello World".repeat(100),
            maxLines = 4,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun RowAndColumn() {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f, MaterialTheme.colors.secondary)
            CustomItem(1f, MaterialTheme.colors.primary)
            CustomItem(1f, MaterialTheme.colors.secondary)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f, MaterialTheme.colors.primary)
            CustomItem(1f, MaterialTheme.colors.secondary)
            CustomItem(1f, MaterialTheme.colors.primary)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomItem(1f, MaterialTheme.colors.secondary)
            CustomItem(1f, MaterialTheme.colors.primary)
            CustomItem(1f, MaterialTheme.colors.secondary)
        }
    }
}

@Composable
fun Boxes() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .background(
                        color = MaterialTheme.colors.secondaryVariant, shape = Shapes.medium
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Hello World, Whats up!!", style = Typography.h1
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.background(
                    color = MaterialTheme.colors.background, shape = Shapes.medium
                )
            ) {
                Text(
                    text = "Hello World", fontSize = 16.sp, fontWeight = FontWeight.Bold
                )
            }
        }
    }


}


@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .weight(weight)
            .fillMaxWidth(), color = color
    ) {}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleProjectTheme {
        run()
    }
}

