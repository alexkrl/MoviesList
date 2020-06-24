package com.example.movieslisttask.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by alexkorolov on 2020-01-15.
 */
@Parcelize
@Entity(tableName = "movies_table")
data class Movie(
        @SerializedName("vote_count")
        var voteCount: Int? = null,

        @SerializedName("id")
        @PrimaryKey
        var id: Int? = null,

        @SerializedName("video")
        var video: Boolean? = null,

        @SerializedName("vote_average")
        var voteAverage: Double? = null,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("popularity")
        var popularity: Double? = null,

        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("original_language")
        var originalLanguage: String? = null,

        @SerializedName("original_title")
        var originalTitle: String? = null,

        @SerializedName("genre_ids")
        @Ignore
        var genreIds: List<Int> = ArrayList(),

        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @SerializedName("adult")
        var adult: Boolean? = null,

        @SerializedName("overview")
        var overview: String? = null,

        @SerializedName("release_date")
        var releaseDate: String? = null,

        var favoriteMovie: Int? = 0


) : Parcelable