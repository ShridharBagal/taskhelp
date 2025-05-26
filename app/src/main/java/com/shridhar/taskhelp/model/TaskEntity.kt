package com.shridhar.taskhelp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val isDone: Boolean = false,
    val dueDate: Long? = null,
    val remindAt: Long? = null
)