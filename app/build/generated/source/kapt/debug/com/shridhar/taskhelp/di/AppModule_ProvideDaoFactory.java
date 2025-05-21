package com.shridhar.taskhelp.di;

import com.shridhar.taskhelp.data.TaskDao;
import com.shridhar.taskhelp.data.TaskDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideDaoFactory implements Factory<TaskDao> {
  private final Provider<TaskDatabase> dbProvider;

  public AppModule_ProvideDaoFactory(Provider<TaskDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TaskDao get() {
    return provideDao(dbProvider.get());
  }

  public static AppModule_ProvideDaoFactory create(Provider<TaskDatabase> dbProvider) {
    return new AppModule_ProvideDaoFactory(dbProvider);
  }

  public static TaskDao provideDao(TaskDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDao(db));
  }
}
