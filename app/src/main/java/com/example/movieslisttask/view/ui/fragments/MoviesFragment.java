package com.example.movieslisttask.view.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieslisttask.R;
import com.example.movieslisttask.databinding.FragmentMoviesBinding;
import com.example.movieslisttask.model.Movie;
import com.example.movieslisttask.tools.Consts;
import com.example.movieslisttask.view.adapter.MovieAdapter;
import com.example.movieslisttask.viewmodel.MoviesViewModel;

import java.util.ArrayList;

/**
 * Created by alexkorolov on 2020-01-17.
 */
public class MoviesFragment extends Fragment {

    private ArrayList<Movie> movies;
    private FragmentMoviesBinding moviesBinding;
    private MovieAdapter movieAdapter;
    private MoviesViewModel moviesViewModel;
    private boolean isFavoritesFrag = false;

    public static MoviesFragment newInstance(boolean favorites) {
        MoviesFragment retFrag = new MoviesFragment();

        Bundle args = new Bundle();
        args.putBoolean(Consts.SHOW_FAVORITES, favorites);
        retFrag.setArguments(args);

        return retFrag;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);

        if (getArguments() != null) {
            isFavoritesFrag = getArguments().getBoolean(Consts.SHOW_FAVORITES);
        }

        getMovies();

        return moviesBinding.getRoot();
    }

    private void getMovies() {
        if (isFavoritesFrag) {
            moviesViewModel.getAllFavorites().observe(getViewLifecycleOwner(), moviesFromLiveData -> {
                movies = (ArrayList<Movie>) moviesFromLiveData;
                handleDataReceived();
            });
        } else {
            moviesViewModel.getallMovies().observe(getViewLifecycleOwner(), moviesFromLiveData -> {
                movies = (ArrayList<Movie>) moviesFromLiveData;
                handleDataReceived();
            });
        }
    }

    private void handleDataReceived() {
        if (movieAdapter == null) {
            RecyclerView recyclerView = moviesBinding.moviesList;
            movieAdapter = new MovieAdapter(getActivity(), movies);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(movieAdapter);
        } else {
            movieAdapter.updateMoviesList(movies);
        }
    }
}
