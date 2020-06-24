package com.example.movieslisttask.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.movieslisttask.R
import com.example.movieslisttask.ui.movies_list.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val popularMoviesFragment = MoviesFragment.newInstance(false)
    private val favoritesMoviesFragment = MoviesFragment.newInstance(true)

    private var active: Fragment = popularMoviesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, favoritesMoviesFragment, "favorites")
                .hide(favoritesMoviesFragment)
                .commit()
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, popularMoviesFragment, "popular")
                .commit()
    }

    private val navigationItemSelectedListener =
            label@ BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_popular -> {
                supportFragmentManager.beginTransaction().hide(active).show(popularMoviesFragment).commit()
                active = popularMoviesFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                supportFragmentManager.beginTransaction().hide(active).show(favoritesMoviesFragment).commit()
                active = favoritesMoviesFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}