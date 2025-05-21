package com.shridhar.taskhelp.repository

import com.shridhar.taskhelp.data.TaskDao
import com.shridhar.taskhelp.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {
    override fun getTasks(): Flow<List<Task>> =
        dao.getAllTasks().map { entities -> entities.map(TaskEntity::toTask) }

    override suspend fun addTask(task: Task) {
        dao.insertTask(task.toEntity())
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(task.toEntity())
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task.toEntity())
    }
}
