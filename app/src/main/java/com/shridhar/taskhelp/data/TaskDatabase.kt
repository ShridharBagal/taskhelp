package com.shridhar.taskhelp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shridhar.taskhelp.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
