package com.shridhar.taskhelp.model

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val isDone: Boolean = false,
    val dueDate: Long? = null,
    val remindAt: Long? = null
)