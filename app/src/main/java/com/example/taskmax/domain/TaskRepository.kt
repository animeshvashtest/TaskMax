package com.example.taskmax.domain

import kotlinx.coroutines.flow.Flow

class TaskRepository {
    fun getTask(): Flow<List<Task>>
    suspend fun addTask(task: Task)

}