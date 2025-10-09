package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.EaseOutCirc
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
        Column(

        ) {
            List()
        }
}

@Composable
fun List() {
    val sentences = listOf(
       "tere ek pal dil nayo lagda",
        "badhi mushkil hai ye zindagi aur kya karen samjha nahi hai",
         "tera time jarura ayega tu zara sabra rakh yaar",
        "hai jo irade bada dun tumko",
        "sarma hi jayogi tum ",
        "dharkne jo suna dun tumko ",
        "tere ek pal dil nayo lagda",
        "badhi mushkil hai ye zindagi aur kya karen samjha nahi hai",
        "tera time jarura ayega tu zara sabra rakh yaar",
        "hai jo irade bada dun tumko",
        "sarma hi jayogi tum ",
        "dharkne jo suna dun tumko ",
        "tere ek pal dil nayo lagda",
        "badhi mushkil hai ye zindagi aur kya karen samjha nahi hai",
        "tera time jarura ayega tu zara sabra rakh yaar",
        "hai jo irade bada dun tumko",
        "sarma hi jayogi tum ",
        "dharkne jo suna dun tumko ",
        "tere ek pal dil nayo lagda",
        "badhi mushkil hai ye zindagi aur kya karen samjha nahi hai",
        "tera time jarura ayega tu zara sabra rakh yaar",
        "hai jo irade bada dun tumko",
        "sarma hi jayogi tum ",
        "dharkne jo suna dun tumko ",
    )

        TextItemView(sentences)
}

@Composable
fun TextItemView(sentence: List<String>) {
    val customFont = Font(R.font.myboldfont)
    val customFontFamily = FontFamily(customFont)

    LazyColumn {
        items(sentence) { item ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color.Black)
            ) {
                Text(
                    text = item,
                    fontSize = 24.sp,
                    fontFamily = customFontFamily,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

}