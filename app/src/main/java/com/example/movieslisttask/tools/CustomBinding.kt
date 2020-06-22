package com.example.movieslisttask.tools


import android.content.res.Resources
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieslisttask.R
import com.example.movieslisttask.ui.movies_list.MovieViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * Created by alexkorolov on 22/06/2020.
 */

@BindingAdapter("loadImage")
fun bindingMoviePoster(imageHolder : ImageView, imageId : String){
    val imagePath = "https://image.tmdb.org/t/p/w500$imageId"
    Glide.with(imageHolder.context)
            .load(imagePath)
            .into(imageHolder)
}

@BindingAdapter("initFavorite")
fun initFavoriteIndicator(favoriteIndicator: FloatingActionButton, isFavorite: Int) {
    val theme: Resources.Theme = favoriteIndicator.context.resources.newTheme()
    if (isFavorite == 1) {
        theme.applyStyle(R.style.LikeScene, false)
    } else {
        theme.applyStyle(R.style.DefaultScene, false)
    }
    val drawable = ResourcesCompat.getDrawable(favoriteIndicator.context.resources,
            R.drawable.ic_add_to_favorite, theme)
    favoriteIndicator.setImageDrawable(drawable)
}

