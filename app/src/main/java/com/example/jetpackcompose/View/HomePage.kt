package com.example.jetpackcompose.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ViewModel.HomeViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val userData = viewModel.userData.observeAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.getUserData()
            }
        ) { Text("Get Data") }

        userData.value?.name?.let {
            Text("Name: $it")
        }
        userData.value?.age?.let {
            Text("Age: $it")
        }
    }
}