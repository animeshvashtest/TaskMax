package com.example.taskmax

import com.example.taskmax.domain.Task
import com.example.taskmax.domain.TaskRepository

class AddTaskUseCase(private val taskRepository: TaskRepository) {
    suspend fun execute(title: String) {
        taskRepository.addTask(Task(title = title, isDone = false))
    }
}