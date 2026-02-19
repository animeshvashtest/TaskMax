package com.example.taskmax.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1, exportSchema = Boolean)
abstract class Taskdatabase: RoomDatabase() {

    abstract fun taskMaxDao(): TaskMaxDao
}