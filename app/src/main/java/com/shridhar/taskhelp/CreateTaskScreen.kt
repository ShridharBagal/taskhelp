package com.shridhar.taskhelp

import android.app.TimePickerDialog
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.shridhar.taskhelp.model.Task
import com.shridhar.taskhelp.viewmodel.TaskViewModel
import java.text.DateFormat
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskScreen(
    viewModel: TaskViewModel,
    onTaskSaved: () -> Unit
) {
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var dueDateMillis by remember { mutableStateOf<Long?>(null) }
    var remindAtMillis by remember { mutableStateOf<Long?>(null) }

    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { showDatePicker = true }) {
            Text(if (dueDateMillis != null)
                "Due: ${DateFormat.getDateTimeInstance().format(Date(dueDateMillis!!))}"
            else "Pick Due Date")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = { showTimePicker = true }) {
            Text(if (remindAtMillis != null)
                "Remind At: ${DateFormat.getDateTimeInstance().format(Date(remindAtMillis!!))}"
            else "Pick Reminder Time")
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.addTaskAndScheduleReminder(
                    context = context,
                    title = title,
                    description = description,
                    dueDate = dueDateMillis,
                    remindAt = remindAtMillis,
                    onDone = onTaskSaved
                )
            },
            enabled = title.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Task")
        }
    }

    // Inline DatePicker
    if (showDatePicker) {
        android.app.DatePickerDialog(
            context,
            { _, year, month, day ->
                calendar.set(year, month, day)
                dueDateMillis = calendar.timeInMillis
                showDatePicker = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    // Inline TimePicker
    if (showTimePicker) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                calendar.set(Calendar.SECOND, 0)
                remindAtMillis = calendar.timeInMillis
                showTimePicker = false
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()
    }
}

