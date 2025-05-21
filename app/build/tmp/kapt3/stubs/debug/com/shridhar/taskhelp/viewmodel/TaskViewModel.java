package com.shridhar.taskhelp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/shridhar/taskhelp/viewmodel/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/shridhar/taskhelp/repository/TaskRepository;", "(Lcom/shridhar/taskhelp/repository/TaskRepository;)V", "tasks", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/shridhar/taskhelp/model/Task;", "getTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "addTask", "", "title", "", "description", "toggleTaskCompleted", "task", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.shridhar.taskhelp.repository.TaskRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.shridhar.taskhelp.model.Task>> tasks = null;
    
    @javax.inject.Inject()
    public TaskViewModel(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.repository.TaskRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.shridhar.taskhelp.model.Task>> getTasks() {
        return null;
    }
    
    public final void addTask(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    public final void toggleTaskCompleted(@org.jetbrains.annotations.NotNull()
    com.shridhar.taskhelp.model.Task task) {
    }
}