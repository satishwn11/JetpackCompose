package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.View.HomePage
import com.example.jetpackcompose.ViewModel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel = ViewModelProvider(this) [HomeViewModel::class]

        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                HomePage(modifier = Modifier.padding(paddingValues), homeViewModel)
            }
        }
    }
}




