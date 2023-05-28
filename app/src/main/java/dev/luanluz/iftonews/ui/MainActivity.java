package dev.luanluz.iftonews.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dev.luanluz.iftonews.R;
import dev.luanluz.iftonews.ui.fragments.ClosedNoticesRssFragment;
import dev.luanluz.iftonews.ui.fragments.NewsRssFragment;
import dev.luanluz.iftonews.ui.fragments.NoticesRssFragment;
import dev.luanluz.iftonews.ui.fragments.SystemsFragment;


public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnItemSelectedListener {

    private MaterialToolbar materialToolbar;
    private BottomNavigationView bottomNavigationView;
    private final NewsRssFragment newsFragment = new NewsRssFragment(this);
    private final NoticesRssFragment noticesFragment = new NoticesRssFragment(this);
    private final ClosedNoticesRssFragment closedNoticesFragment = new ClosedNoticesRssFragment(this);
    private final SystemsFragment systemsFragment = new SystemsFragment();

    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.topAppBar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.news);
    }

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.news) {
            materialToolbar.setSubtitle(R.string.news);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, newsFragment)
                .commit();
            return true;

        } else if (itemId == R.id.notices) {
            materialToolbar.setSubtitle(R.string.notices);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, noticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.closed_notices) {
            materialToolbar.setSubtitle(R.string.closed_notices);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, closedNoticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.systems) {
            materialToolbar.setSubtitle(R.string.systems);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, systemsFragment)
                .commit();
            return true;
        }

        return false;
    }
}