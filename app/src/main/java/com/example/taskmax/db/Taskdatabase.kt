package com.example.taskmax.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmax.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = Boolean)
abstract class Taskdatabase: RoomDatabase() {

    abstract fun taskMaxDao(): TaskMaxDao
}