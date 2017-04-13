package com.charlesdrews.dontforget;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.WindowCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int DAILY_SUMMARY = 0;
    private static final int WEATHER = 1;
    private static final int TASKS = 2;
    private static final int BIRTHDAYS = 3;

    private int mSelectedFragment = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccentDark));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navDrawer = (NavigationView) findViewById(R.id.nav_view);
        navDrawer.setNavigationItemSelectedListener(this);

        BottomNavigationView navBottom = (BottomNavigationView) findViewById(R.id.bottom_nav);
        navBottom.setOnNavigationItemSelectedListener(getBottomNavSelectListener());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
        switch (item.getItemId()) {
            case R.id.action_settings:
                showSettings();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_summary:
                showDailySummary();
                break;
            case R.id.nav_weather:
                showWeather();
                break;
            case R.id.nav_tasks:
                showTasks();
                break;
            case R.id.nav_birthdays:
                showBirthdays();
                break;
            case R.id.nav_settings:
                showSettings();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener getBottomNavSelectListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_bottom_summary:
                        showDailySummary();
                        return true;
                    case R.id.nav_bottom_weather:
                        showWeather();
                        return true;
                    case R.id.nav_bottom_tasks:
                        showTasks();
                        return true;
                    case R.id.nav_bottom_birthdays:
                        showBirthdays();
                        return true;
                }
                return false;
            }
        };
    }

    private void showDailySummary() {
        Toast.makeText(this, "Daily Summary", Toast.LENGTH_SHORT).show();
    }

    private void showWeather() {
        Toast.makeText(this, "Weather", Toast.LENGTH_SHORT).show();
    }

    private void showTasks() {
        Toast.makeText(this, "Tasks", Toast.LENGTH_SHORT).show();
    }

    private void showBirthdays() {
        Toast.makeText(this, "Birthdays", Toast.LENGTH_SHORT).show();
    }

    private void showSettings() {
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
    }
}
