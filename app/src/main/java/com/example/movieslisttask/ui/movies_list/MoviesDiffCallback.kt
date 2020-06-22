package com.example.movieslisttask.ui.movies_list

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 22/06/2020.
 */
class MoviesDiffCallback (private val oldList: List<Movie>, private val newList: List<Movie>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id === newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return  oldList[oldPosition].favoriteMovie == newList[newPosition].favoriteMovie
    }
}