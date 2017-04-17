package com.charlesdrews.dontforget.summary;

import com.charlesdrews.dontforget.data.DataSource;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by charlie on 4/14/17.
 */

public class SummaryPresenter implements SummaryContract.Presenter {

    private DataSource mDataSource;
    private SummaryContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    public SummaryPresenter(DataSource dataSource, SummaryContract.View view) {
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
