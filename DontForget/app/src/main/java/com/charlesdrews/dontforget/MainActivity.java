package com.charlesdrews.dontforget;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        BaseFragment.OnFragmentInteractionListener {

    private static final int INVALID_SELECTION = -1;
    private static final int DAILY_SUMMARY = 0;
    private static final int WEATHER = 1;
    private static final int TASKS = 2;
    private static final int BIRTHDAYS = 3;
    private static final int SETTINGS = 4;

    private int mLastSelection = DAILY_SUMMARY;
    private NavigationView mNavDrawer;
    private DrawerLayout mNavDrawerLayout;
    private BottomNavigationView mNavBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mNavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mNavDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mNavDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavDrawer = (NavigationView) findViewById(R.id.nav_view);
        mNavDrawer.setNavigationItemSelectedListener(this);

        mNavBottom = (BottomNavigationView) findViewById(R.id.bottom_nav);
        mNavBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return handleNavSelection(item.getItemId());
            }
        });

        replaceFragment(getSelectedFragment());
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
        return handleNavSelection(item.getItemId());
    }

    // Sufficient to implement both NavigationView.OnNavigationItemSelectedListener
    // and BottomNavigationView.OnNavigationItemSelectedListener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return handleNavSelection(item.getItemId());
    }

    private boolean handleNavSelection(int selectionResId) {
        int newSelection = getSelectionIndex(selectionResId);

        if (newSelection == INVALID_SELECTION) {
            return false;
        } else if (newSelection == SETTINGS) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        } else if (newSelection != mLastSelection) {
            mLastSelection = newSelection;
            mNavDrawer.getMenu().getItem(mLastSelection).setChecked(true);
            mNavBottom.getMenu().getItem(mLastSelection).setChecked(true);
            replaceFragment(getSelectedFragment());
        }
        mNavDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

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

    private Fragment getSelectedFragment() {
        switch (mLastSelection) {
            case DAILY_SUMMARY:
                return BaseFragment.newInstance(R.drawable.ic_summary, "");
            case WEATHER:
                return BaseFragment.newInstance(R.drawable.ic_weather, "");
            case TASKS:
                return BaseFragment.newInstance(R.drawable.ic_tasks, "");
            case BIRTHDAYS:
                return BaseFragment.newInstance(R.drawable.ic_birthdays, "");
            default:
                return null;
        }
    }

    private void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
