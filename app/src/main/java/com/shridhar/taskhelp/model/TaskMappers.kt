package com.shridhar.taskhelp.model

fun TaskEntity.toTask() = Task(id, title, description, isDone,dueDate,remindAt)
fun Task.toEntity() = TaskEntity(id, title, description, isDone ,dueDate,remindAt)