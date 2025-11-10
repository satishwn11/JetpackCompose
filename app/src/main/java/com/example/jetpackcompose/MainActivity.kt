package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ViewModel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "TaskScreen"
            ) {
                composable("TaskScreen") {  TaskScreen(navController) }
                composable("WriteScreen") { WriteScreen(navController)}
            }

            }
        }
    }

@Composable
fun TaskScreen(navController: NavController,viewModel: TodoViewModel = viewModel()) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("WriteScreen")
                }
            ) {
               Icon(
                   painter = painterResource(R.drawable.edit_icon),
                   contentDescription = null,
                   Modifier.size(30.dp),
                   tint = Color.Black
               )
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp)
        ) {
            LazyColumn {
                items(viewModel.todos) {  item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Text(item.task,
                            modifier = Modifier
                                .padding(8.dp)
                            )
                    }
                }
            }

        }
    }
}


@Composable
fun WriteScreen(navController: NavController,viewModel: TodoViewModel = viewModel()) {
    var task by remember { mutableStateOf("") }

     Column(
        modifier =  Modifier
            .fillMaxSize()
             .padding(8.dp)) {

         TextField(
             value = task,
             onValueChange = { task = it },
             modifier = Modifier
                 .fillMaxWidth()
                 .height(300.dp),
             placeholder = { Text("Write Something..") },
         )

         Spacer(Modifier.height(4.dp))
         Button(onClick = {
             viewModel.addtodo(task)
             navController.popBackStack()
         }) { Text("Save Note")}

     }
}





@Composable
fun App() {
    val myFont = FontFamily(
        Font(R.font.impact),
        Font(R.font.impacted),
        Font(R.font.impacted),
    )

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color(0xFFFFD99C))
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(6.dp))

            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        spotColor = Color.Black.copy(alpha = 1.5f)
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.image_wordmeaning),
                    contentDescription = "word meaning icon",
                    modifier = Modifier.size(100.dp)
                )
            }

            Spacer(Modifier.width(16.dp))

            Text("Word \nMeanings",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = myFont,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.4f),
                        offset = Offset(0f,8f),
                        blurRadius = 8f
                    )
                )
            )
        }

    }
}
