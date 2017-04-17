package com.charlesdrews.dontforget.birthdays;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.BaseContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;

import java.util.List;

/**
 * Defines responsibilities of View and Presenter for the Birthdays feature
 * Created by charlie on 4/14/17.
 */

public interface BirthdaysContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {

    }

    interface DataSource {
        List<Birthday> getBirthdays();

        boolean saveBirthday(@NonNull Birthday birthday);
    }
}
