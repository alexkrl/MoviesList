package com.example.movieslisttask.view.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.movieslisttask.R;
import com.example.movieslisttask.view.ui.fragments.MoviesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Created by alexkorolov on 2020-01-15.
 */
public class MainActivity extends AppCompatActivity {

    final MoviesFragment popularMoviesFragment = MoviesFragment.newInstance(false);
    final MoviesFragment favoritesMoviesFragment = MoviesFragment.newInstance(true);
    final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = popularMoviesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.navigation);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, favoritesMoviesFragment, "favorites")
                .hide(favoritesMoviesFragment).commit();
        fm.beginTransaction().add(R.id.main_container, popularMoviesFragment, "popular").commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_popular:
                fm.beginTransaction().hide(active).show(popularMoviesFragment).commit();
                active = popularMoviesFragment;
                return true;

            case R.id.navigation_favorite:
                fm.beginTransaction().hide(active).show(favoritesMoviesFragment).commit();
                active = favoritesMoviesFragment;
                return true;
        }
        return false;
    };
}
