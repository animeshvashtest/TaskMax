package com.example.taskmax.data

import com.example.taskmax.domain.Task
import kotlinx.coroutines.flow.Flow

class TaskDataRepository {private val dao: TaskMaxDao): TaskRepository

}

    override fun getTask() : Flow<List<Task>> {
        return dao.getAllTask().map {
            list ->
            list.map { taskEntity ->
                Task(
                    id = taskEntity.id,
                    title = taskEntity.title,
                    isDone = taskEntity.isDone
                )
        }
    }

        override suspend fun addTask(task: Task) {
        dao.add(TaskEntity(title = task.title,
            isDone = task.isDone))
    }

        override suspend fun updateTask(task: Task) {
            dao.update(TaskEntity(title = task.title,
                isDone = task.isDone))
        }


        override suspend fun deleteTask(task: Task) {
            dao.delete(TaskEntity(title = task.title,
                isDone = task.isDone))
        }


}
}