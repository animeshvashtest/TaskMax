package com.example.taskmax.domain

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskmax.enums.Priority
import com.example.taskmax.enums.Status
import com.example.taskmax.enums.Tags
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime

@Entity("mytasks")
data class Task @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String? = null,
    val priority: Priority,
    val status: Status,
    val dueDate: LocalDate? = null,
    val dueTime: LocalTime?= null,
    val reminderAt: Instant? = null,
    val tags: Tags,
    val isPinned: Boolean = false,
    ) {

}