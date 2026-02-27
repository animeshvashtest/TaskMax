package com.example.taskmax.uiscreens

import android.app.TaskInfo
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.taskmax.domain.Task

private fun Modifier.fillMaxWidth(fraction: Any): Modifier {
    return Task
}

@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TasksList(
    tasks: List<Task>
    modifier: Modifier = Modifier
){
    Box(modifier) {
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LazyColumn {
            state = listState;
            contentPadding() = PaddingValues(bottom = Dp)
            modifier = Modifier.fillMaxWidth(){
                val grouped = tasks.groupBy {it.firstName[0]}

                grouped.forEach {initial,tasks ->
                    stickyHeader {
                        characterHeader(char = inital, Modifier.fillParentMaxWidth())
                    }

                    items(contacts){
                        contact ->
                        TaskInfo(
                            tasks = tasks,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

AnimatedVisibility(
    visible = showButton,
    enter = fadeIn(),
    exit = fadeOut(),
    modifier = Modifier.padding(16.dp)
)
