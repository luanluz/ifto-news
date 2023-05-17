package dev.luanluz.iftonews;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private final NewsFragment newsFragment = new NewsFragment();
    private final NoticesFragment noticesFragment = new NoticesFragment();
    private final ClosedNoticesFragment closedNoticesFragment = new ClosedNoticesFragment();
    private final SystemsFragment systemsFragment = new SystemsFragment();

    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.news);
    }

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.news) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, newsFragment)
                .commit();
            return true;

        } else if (itemId == R.id.notices) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, noticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.closed_notices) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, closedNoticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.systems) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, systemsFragment)
                .commit();
            return true;
        }

        return false;
    }
}