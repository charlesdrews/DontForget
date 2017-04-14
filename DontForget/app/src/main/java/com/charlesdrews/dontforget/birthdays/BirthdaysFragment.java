package com.charlesdrews.dontforget.birthdays;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.dontforget.R;

public class BirthdaysFragment extends Fragment implements BirthdaysContract.View {

    private BirthdaysContract.Presenter mPresenter;

    public BirthdaysFragment() {/* Required empty public constructor */}

    public static BirthdaysFragment newInstance() {
        // If this fragment ever needs inputs, supply them here via setArguments()
        return new BirthdaysFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_birthdays, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void setPresenter(@NonNull BirthdaysContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
