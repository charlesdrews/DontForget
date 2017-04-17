package com.charlesdrews.dontforget.birthdays;

import com.charlesdrews.dontforget.birthdays.model.Birthday;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by charlie on 4/14/17.
 */

public class BirthdaysPresenter implements BirthdaysContract.Presenter {

    private BirthdaysContract.DataSource mDataSource;
    private BirthdaysContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    public BirthdaysPresenter(BirthdaysContract.DataSource dataSource, BirthdaysContract.View view) {
        mDataSource = dataSource;
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribeView() {
        //TODO - this is just hypothetical example code, not usable
        Single.fromCallable(new Callable<List<Birthday>>() {
            @Override
            public List<Birthday> call() throws Exception {
                return mDataSource.getBirthdays();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Birthday>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull List<Birthday> birthdays) {
                        // Show birthdays in the view
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        // Show an error message
                    }
                });

        Single.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mDataSource.saveBirthday(new Birthday(1, "", 1, 1, 1, true));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Boolean aBoolean) {
                        // Show "success" message in view if aBoolean is true
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        // Show "error" message in view
                    }
                });

    }

    @Override
    public void unsubscribeView() {
        mCompositeDisposable.dispose();
    }
}
