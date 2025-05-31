package com.shridhar.taskhelp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shridhar.taskhelp.model.Task
import com.shridhar.taskhelp.viewmodel.TaskViewModel
import java.text.DateFormat
import java.util.Date
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import com.shridhar.taskhelp.TaskItem as TaskItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: TaskViewModel,
    onAddTaskClicked: () -> Unit
) {
    val tasks by viewModel.tasks.collectAsState()
    Log.i("home" , tasks.toString())

    val fabColor = MaterialTheme.colorScheme.primary


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TaskHelp") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = fabColor,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTaskClicked,
                containerColor = fabColor,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { padding ->
        if (tasks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No tasks yet! Tap + to add one.")
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onCheckedChange = {
                            viewModel.toggleTaskCompleted(task)
                        },
                        onDeleteClick = {
                            viewModel.deleteTask(task)
                        }
                    )
                }
            }
        }
    }
}



@Composable
fun TaskItem(
    task: Task,
    onCheckedChange: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
        containerColor = Color(0xFFD7E7D7)
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(
                onClick = { expanded = !expanded },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = task.isDone,
                    onCheckedChange = { onCheckedChange(it) }
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                    ),
                    color = if (task.isDone) Color.Gray else LocalContentColor.current,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = onDeleteClick) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete Task")
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(start = 40.dp, top = 4.dp)) {
                    Text(text = task.description,
                        style = MaterialTheme.typography.titleMedium.copy(
                            textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                        ),
                        color = if (task.isDone) Color.Gray else LocalContentColor.current,fontSize = 14.sp)
                    task.dueDate?.let {
                        Text(
                            text = "Due: ${DateFormat.getDateInstance().format(Date(it))}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                            ),
                            color = if (task.isDone) Color.Gray else LocalContentColor.current,
                            fontSize = 11.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    task.remindAt?.let {
                        Text(
                            text = "Remind at: ${DateFormat.getDateTimeInstance().format(Date(it))}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                            ),
                            color = if (task.isDone) Color.Gray else LocalContentColor.current,
                            fontSize = 11.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}




