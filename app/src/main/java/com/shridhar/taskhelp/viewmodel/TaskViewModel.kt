package com.shridhar.taskhelp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.shridhar.taskhelp.ReminderWorker
import com.shridhar.taskhelp.model.Task
import com.shridhar.taskhelp.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks: StateFlow<List<Task>> = repository.getTasks()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addTask(
        title: String,
        description: String,
        dueDate: Long? = null,
        remindAt: Long? = null,
        isDone: Boolean
    ) {
        viewModelScope.launch {
            val task = Task(
                0,
                title = title,
                description = description,
                dueDate = dueDate,
                remindAt = remindAt,
                isDone = isDone,
            )
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun toggleTaskCompleted(task: Task) {
        val updated = task.copy(isDone = !task.isDone)
        updateTask(updated)
    }

    fun addTaskAndScheduleReminder(
        context: Context,
        title: String,
        description: String,
        dueDate: Long?,
        remindAt: Long?,
        onDone: () -> Unit
    ) {
        viewModelScope.launch {
            val task = Task(
                title = title,
                description = description,
                dueDate = dueDate,
                remindAt = remindAt,
                isDone = false,
                id=0
            )
            val savedTask = repository.addTask(task)
            savedTask.remindAt?.let {
                scheduleReminder(context, savedTask)
            }
            onDone()
        }
    }

    fun scheduleReminder(context: Context, task: Task) {
        val delayMillis = task.remindAt?.minus(System.currentTimeMillis()) ?: return
        if (delayMillis <= 0) return // Prevent scheduling past reminders

        val data = workDataOf(
            "title" to task.title,
            "description" to task.description
        )

        val request = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
            .setInputData(data)
            .build()

        WorkManager.getInstance(context).enqueue(request)
    }


}