package com.example.taskmax.uiscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskmax.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Taskscreen(taskViewModel: TaskViewModel){
    var task by remember {mutableStateOf("") }
    val taskList by taskViewModel.tasks.collectAsState()

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Task List") },
                colors = TopAppBarDefaults.topAppBarColors()
                containerColor = Color.Red,
                titleContentColor = Color.White
            )
        }
    ){
        innerPadding ->
        Column { var modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
            ){
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)){ }
            }

    }
}

class Taskscreen {
}