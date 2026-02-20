package com.example.taskmax.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.taskmax.AddTaskUseCase
import com.example.taskmax.data.Taskdatabase
import com.example.taskmax.domain.Task

open class TaskViewModel : ViewModel(application: Application) : AndroidViewModel{

    private val db = Room.databaseBuilder  (
        application, Taskdatabase::class.java,
        "my_task_db"
    ).build()

    private val taskRepository = taskDataRepository (db.taskMaxDao())
    private val addTaskUseCase = AddTaskUseCase(taskRepository)

    open val tasks: taskRepository.getTask().stateIn(
            viewModelScope, SharingStarted.Lazily, initial
    )

    fun addTask(title: String){
        viewModelFactory.launch {
                addTaskUseCase.execute(title)
        }
    }

    fun toggleTaskDone(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTask(task.copy(isDone))
        }
    }

    fun editTask(task:Task, newTitle: String){
        viewModelScope.launch {
            if (newTitle.isNotBlank()) {
                taskRepository.updateTask(task.copy())
            }

            fun deleteTask(task: Task) {
                viewModelScope.launch {
                    taskRepository.deleteTask(task)
                }
            }

        }