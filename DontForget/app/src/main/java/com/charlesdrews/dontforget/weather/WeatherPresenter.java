package com.charlesdrews.dontforget.weather;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by charlie on 4/14/17.
 */

public class WeatherPresenter implements WeatherContract.Presenter {

    private WeatherContract.DataSource mDataSource;
    private WeatherContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    public WeatherPresenter(WeatherContract.DataSource dataSource, WeatherContract.View view) {
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

    @Override
    public void onRefreshRequested() {
        //TODO
    }
}
