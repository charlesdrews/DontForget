package com.charlesdrews.dontforget.tasks;

import com.charlesdrews.dontforget.BaseContract;

/**
 * Defines responsibilities of View and Presenter for the Tasks feature
 * Created by charlie on 4/14/17.
 */

public interface TasksContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {

    }
}
