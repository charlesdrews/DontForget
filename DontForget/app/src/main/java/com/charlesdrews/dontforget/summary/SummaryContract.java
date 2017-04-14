package com.charlesdrews.dontforget.summary;

import com.charlesdrews.dontforget.BaseContract;

/**
 * Defines responsibilities of View and Presenter for the Daily Summary feature
 * Created by charlie on 4/14/17.
 */

public interface SummaryContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {

    }
}
