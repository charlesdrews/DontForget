package com.charlesdrews.dontforget;

import android.support.annotation.NonNull;

/**
 * Parent types for all Views and Presenters
 * Created by charlie on 4/14/17.
 */

public interface BaseContract {

    interface View<P extends Presenter> {
        void setPresenter(@NonNull P presenter);
    }

    interface Presenter {
        void onViewReady();
    }
}
