package com.charlesdrews.dontforget.tasks;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.BaseContract;
import com.charlesdrews.dontforget.tasks.model.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Defines responsibilities of View and Presenter for the Tasks feature
 * Created by charlie on 4/14/17.
 */

public interface TasksContract {

    int BEFORE_WORK = 0;
    int LUNCHTIME = 1;
    int AFTER_WORK = 2;
    int EVENING = 3;

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {

    }

    interface DataSource {
        Observable<List<Task>> getTasks();

        Completable saveTask(@NonNull Task task);

        Completable updateTask(@NonNull Task task);

        Completable deleteTask(@NonNull Task task);

        Completable deleteTask(long taskId);

        interface Local {
            List<Task> getTasks();

            long saveTask(@NonNull Task task);

            boolean updateTask(@NonNull Task task);

            boolean deleteTask(@NonNull Task task);

            boolean deleteTask(long taskId);
        }
    }
}
