package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                        GreetingImage(stringResource(R.string.happy_birthday_text), from = "From Kathembo")
                    }
                }
            }
        }
    }



@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    //create a column so that texts don't overlap
    Column(
        //this arrangement will center the text in the app
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 70.sp,
            textAlign = TextAlign.Center,
            )
        Text(text = from,
            fontSize = 20.sp,
            modifier = modifier
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
            )
    }
}
// Add an image to your application
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ciel3)

    // Create a box to overlap the image and texts
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Center the content within the Box
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            )
    }
}



// This previous helps to preview how will the text appear in the applilcation

@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
    HappyBirthdayTheme {
    GreetingImage(stringResource(R.string.happy_birthday_text),
        stringResource(R.string.signature_text)
    )
    }
}


