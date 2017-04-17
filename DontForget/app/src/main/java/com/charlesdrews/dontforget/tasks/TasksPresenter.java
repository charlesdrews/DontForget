package com.charlesdrews.dontforget.tasks;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by charlie on 4/14/17.
 */

public class TasksPresenter implements TasksContract.Presenter {

    private TasksContract.DataSource mDataSource;
    private TasksContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    public TasksPresenter(TasksContract.DataSource dataSource, TasksContract.View view) {
        mDataSource = dataSource;
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribeView() {
        //TODO
    }

    @Override
    public void unsubscribeView() {
        mCompositeDisposable.dispose();
    }
}