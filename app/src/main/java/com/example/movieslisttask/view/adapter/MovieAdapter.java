package com.example.movieslisttask.view.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieslisttask.R;
import com.example.movieslisttask.databinding.MovieListItemBinding;
import com.example.movieslisttask.model.Movie;
import com.example.movieslisttask.model.MovieDBRepository;
import com.example.movieslisttask.view.ui.activities.MovieInfoActivity;

import java.util.ArrayList;

/**
 * Created by alexkorolov on 2020-01-15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);

        initFavoriteIndicator(holder, position);
    }

    private void initFavoriteIndicator(MovieViewHolder holder, int position) {
        final Resources.Theme theme = context.getResources().newTheme();
        if (movieArrayList.get(position).getIsFavoiteMovie() == 1) {
            theme.applyStyle(R.style.LikeScene, false);
        } else {
            theme.applyStyle(R.style.DefaultScene, false);
        }

        final Drawable drawable = ResourcesCompat.getDrawable(context.getResources(),
                R.drawable.ic_add_to_favorite, theme);

        holder.movieListItemBinding.favoriteIndicator.setImageDrawable(drawable);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public void updateMoviesList(ArrayList<Movie> newMovies) {
        movieArrayList = newMovies;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemBinding movieListItemBinding;


        MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(view -> {
                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION) {

                    Movie selctedMovie = movieArrayList.get(position);

                    Intent intent = new Intent(context, MovieInfoActivity.class);
                    intent.putExtra("movie", selctedMovie);


                    Pair<View, String> imagePair = new Pair<>(movieListItemBinding.moviePoster, "image_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, imagePair);

                    context.startActivity(intent, options.toBundle());
                }
            });

            movieListItemBinding.favoriteIndicator.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Movie movie = movieArrayList.get(position);

                if (movie.getIsFavoiteMovie() == 1) {
                    movie.setIsFavoiteMovie(0);

                } else {
                    movie.setIsFavoiteMovie(1);
                }

                MovieDBRepository dbRepository = new MovieDBRepository((Application) context.getApplicationContext());
                dbRepository.updateMovie(movie);
                notifyItemChanged(position);

            });
        }
    }
}
