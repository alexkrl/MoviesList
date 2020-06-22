package com.example.movieslisttask.service.responses

import com.example.movieslisttask.db.entities.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MoviesResponse {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalMovies: Int? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("results")
    @Expose
    var movies: List<Movie>? = null

}