package com.charlesdrews.dontforget.birthdays;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.BaseContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

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
        Observable<List<Birthday>> getBirthdays();

        Completable updateBirthday(@NonNull Birthday birthday);

        interface Local {
            List<Birthday> getBirthdays();

            long saveBirthday(Birthday birthday);

            boolean updateBirthday(Birthday birthday);
        }

        /**
         * In this case, remote just means external to the app.
         * This data will come from the Contacts content provider.
         */
        interface Remote {
            List<Birthday> getBirthdays();
        }
    }
}
