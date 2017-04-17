package com.charlesdrews.dontforget.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.dontforget.R;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

public class WeatherFragment extends Fragment implements WeatherContract.View {

    private WeatherContract.Presenter mPresenter;

    public WeatherFragment() {/* Required empty public constructor */}

    public static WeatherFragment newInstance() {
        // If this fragment ever needs inputs, supply them here via setArguments()
        return new WeatherFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setPresenter(@NonNull WeatherContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCurrentCondition(@NonNull CurrentCondition currentCondition) {
        //TODO
    }

    @Override
    public void showHourlyForecast(@NonNull List<HourForecast> hourlyForecast) {
        //TODO
    }

    @Override
    public void showDailyForecast(@NonNull List<DayForecast> dailyForecast) {
        //TODO
    }
}
