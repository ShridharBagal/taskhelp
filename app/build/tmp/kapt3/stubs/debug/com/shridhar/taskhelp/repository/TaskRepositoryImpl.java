package com.shridhar.taskhelp.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fH\u0016J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/shridhar/taskhelp/repository/TaskRepositoryImpl;", "Lcom/shridhar/taskhelp/repository/TaskRepository;", "dao", "Lcom/shridhar/taskhelp/data/TaskDao;", "(Lcom/shridhar/taskhelp/data/TaskDao;)V", "addTask", "", "task", "Lcom/shridhar/taskhelp/model/Task;", "(Lcom/shridhar/taskhelp/model/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "getTasks", "Lkotlinx/coroutines/flow/Flow;", "", "updateTask", "app_debug"})
public final class TaskRepositoryImpl implements com.shridhar.taskhelp.repository.TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.shridhar.taskhelp.data.TaskDao dao = null;
    
    public TaskRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.data.TaskDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.shridhar.taskhelp.model.Task>> getTasks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addTask(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}