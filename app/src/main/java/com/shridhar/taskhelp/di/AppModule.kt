package com.shridhar.taskhelp.di

import android.app.Application
import androidx.room.Room
import com.shridhar.taskhelp.data.TaskDao
import com.shridhar.taskhelp.data.TaskDatabase
import com.shridhar.taskhelp.repository.TaskRepository
import com.shridhar.taskhelp.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TaskDatabase =
        Room.databaseBuilder(app, TaskDatabase::class.java, "task_db").build()

    @Provides
    fun provideDao(db: TaskDatabase): TaskDao = db.taskDao()

    @Provides
    fun provideTaskRepository(dao: TaskDao): TaskRepository =
        TaskRepositoryImpl(dao)
}
