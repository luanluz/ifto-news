package dev.luanluz.iftonews.ui;

import android.content.Context;
import android.content.SharedPreferences;
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
    private SharedPreferences preferences;

    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("ifto_news", Context.MODE_PRIVATE);

        materialToolbar = findViewById(R.id.topAppBar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(getSelectedNavigationItem());
    }

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.news) {
            materialToolbar.setSubtitle(R.string.news);
            setSelectedNavigationItem(R.id.news);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, newsFragment)
                .commit();
            return true;

        } else if (itemId == R.id.notices) {
            materialToolbar.setSubtitle(R.string.notices);
            setSelectedNavigationItem(R.id.notices);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, noticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.closed_notices) {
            materialToolbar.setSubtitle(R.string.closed_notices);
            setSelectedNavigationItem(R.id.closed_notices);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, closedNoticesFragment)
                .commit();
            return true;

        } else if (itemId == R.id.systems) {
            materialToolbar.setSubtitle(R.string.systems);
            setSelectedNavigationItem(R.id.systems);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentLayout, systemsFragment)
                .commit();
            return true;
        }

        return false;
    }

    private int getSelectedNavigationItem() {
        return Integer.parseInt(preferences.getString("selectedNavigationItem", Integer.toString(R.id.news)));
    }

    private void setSelectedNavigationItem(int selectedNavigationItem) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("selectedNavigationItem", Integer.toString(selectedNavigationItem));
        editor.apply();
    }
}
