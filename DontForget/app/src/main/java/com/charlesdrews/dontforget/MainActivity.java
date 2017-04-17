package com.charlesdrews.dontforget;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.BirthdaysFragment;
import com.charlesdrews.dontforget.data.DataProvider;
import com.charlesdrews.dontforget.data.DataSource;
import com.charlesdrews.dontforget.data.local.LocalDataSource;
import com.charlesdrews.dontforget.data.remote.BirthdaysRemoteSource;
import com.charlesdrews.dontforget.data.remote.WeatherRemoteSource;
import com.charlesdrews.dontforget.summary.SummaryContract;
import com.charlesdrews.dontforget.summary.SummaryFragment;
import com.charlesdrews.dontforget.tasks.TasksContract;
import com.charlesdrews.dontforget.tasks.TasksFragment;
import com.charlesdrews.dontforget.tasks.model.Task;
import com.charlesdrews.dontforget.weather.WeatherContract;
import com.charlesdrews.dontforget.weather.WeatherFragment;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    public static final int INVALID_SELECTION = -1;
    public static final int DAILY_SUMMARY = 0;
    public static final int WEATHER = 1;
    public static final int TASKS = 2;
    public static final int BIRTHDAYS = 3;
    public static final int SETTINGS = 4;
    public static final int NUM_FRAGMENTS = 4;

    private int mLastSelectionIndex = INVALID_SELECTION;
    private NavigationView mNavDrawer;
    private DrawerLayout mNavDrawerLayout;
    private BottomNavigationView mNavBottom;
    private DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize data sources
        mDataSource = DataProvider.getInstance(
                LocalDataSource.getInstance(this),
                new WeatherRemoteSource(),
                new BirthdaysRemoteSource(getContentResolver())
        );

        // Set up Navigation Drawer
        mNavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mNavDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mNavDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavDrawer = (NavigationView) findViewById(R.id.nav_view);
        mNavDrawer.setNavigationItemSelectedListener(this);

        // Set up Bottom Navigation
        mNavBottom = (BottomNavigationView) findViewById(R.id.bottom_nav);
        mNavBottom.setOnNavigationItemSelectedListener(this);

        // Start out showing the Summary fragment
        handleNavSelection(DAILY_SUMMARY);
    }

    @Override
    public void onBackPressed() {
        if (mNavDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mNavDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return handleNavSelection(getSelectionIndex(item.getItemId()));
    }

    // Sufficient to implement both NavigationView.OnNavigationItemSelectedListener
    // and BottomNavigationView.OnNavigationItemSelectedListener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return handleNavSelection(getSelectionIndex(item.getItemId()));
    }


    // ----------------------------------------------------------------------------------
    // Navigation helper methods
    // ----------------------------------------------------------------------------------
    private int getSelectionIndex(int selectionResId) {
        switch (selectionResId) {
            case R.id.nav_drawer_summary:
            case R.id.nav_bottom_summary:
                return DAILY_SUMMARY;

            case R.id.nav_drawer_weather:
            case R.id.nav_bottom_weather:
                return WEATHER;

            case R.id.nav_drawer_tasks:
            case R.id.nav_bottom_tasks:
                return TASKS;

            case R.id.nav_drawer_birthdays:
            case R.id.nav_bottom_birthdays:
                return BIRTHDAYS;

            case R.id.nav_drawer_settings:
            case R.id.action_settings:
                return SETTINGS;

            default:
                return INVALID_SELECTION;
        }
    }

    private boolean handleNavSelection(int selectionIndex) {
        if (selectionIndex == mLastSelectionIndex) {
            return true;
        }

        mLastSelectionIndex = selectionIndex;
        PresenterCache presenterCache = PresenterCache.getInstance();

        switch (mLastSelectionIndex) {
            case INVALID_SELECTION:
                return false;

            case SETTINGS:
                //TODO
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;

            case DAILY_SUMMARY:
                SummaryFragment summaryFragment = SummaryFragment.newInstance();
                SummaryContract.Presenter summaryPresenter = (SummaryContract.Presenter) presenterCache
                        .getPresenter(DAILY_SUMMARY, mDataSource, summaryFragment);

                summaryFragment.setPresenter(summaryPresenter);
                replaceFragment(summaryFragment);
                break;

            case WEATHER:
                WeatherFragment weatherFragment = WeatherFragment.newInstance();
                WeatherContract.Presenter weatherPresenter = (WeatherContract.Presenter) presenterCache
                        .getPresenter(WEATHER, mDataSource, weatherFragment);

                weatherFragment.setPresenter(weatherPresenter);
                replaceFragment(weatherFragment);
                break;

            case TASKS:
                TasksFragment tasksFragment = TasksFragment.newInstance();
                TasksContract.Presenter tasksPresenter = (TasksContract.Presenter) presenterCache
                        .getPresenter(TASKS, mDataSource, tasksFragment);

                tasksFragment.setPresenter(tasksPresenter);
                replaceFragment(tasksFragment);
                break;

            case BIRTHDAYS:
                BirthdaysFragment birthdaysFragment = BirthdaysFragment.newInstance();
                BirthdaysContract.Presenter birthdaysPresenter = (BirthdaysContract.Presenter) presenterCache
                        .getPresenter(BIRTHDAYS, mDataSource, birthdaysFragment);

                birthdaysFragment.setPresenter(birthdaysPresenter);
                replaceFragment(birthdaysFragment);
                break;
        }

        mNavDrawer.getMenu().getItem(mLastSelectionIndex).setChecked(true);
        mNavDrawerLayout.closeDrawer(GravityCompat.START);

        mNavBottom.getMenu().getItem(mLastSelectionIndex).setChecked(true);
        return true;
    }

    private void replaceFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
