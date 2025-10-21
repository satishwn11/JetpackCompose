package com.example.jetpackcompose.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ViewModel.viewModel

@Composable
fun MainScreen(vModel: viewModel = viewModel()) {
    val vowels by vModel.result.observeAsState("Vowels: 0")
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(vowels,
            fontSize = 44.sp,
            fontWeight = FontWeight.ExtraBold)

        TextField(
            value = text,
            onValueChange = { text = it } ,
            placeholder = {Text("Write a word!")}
        )

        Spacer(Modifier.height(6.dp))

        Button(onClick = {
            vModel.checkVowel(text)
        }
        ) { Text("check") }

    }
}