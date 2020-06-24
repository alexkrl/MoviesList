package com.example.movieslisttask.di

import android.content.Context
import androidx.room.Room
import com.example.movieslisttask.db.AppRoomDataBase
import com.example.movieslisttask.model.MovieRepository
import com.example.movieslisttask.service.APIService
import com.example.movieslisttask.tools.Consts.BASE_API_URL
import com.example.movieslisttask.ui.movies_list.MoviesViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by alexkorolov on 21/06/2020.
 */

val appModule = module {

    single { getDatabase(get()) }
    single { createWebService() }

    factory { MovieRepository(get(), get()) }

    viewModel { MoviesViewModel(get()) }
}

fun createWebService(): APIService {

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    return Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
}

private fun getDatabase(context: Context): AppRoomDataBase {
    synchronized(context) {
        return Room.databaseBuilder(
                context.applicationContext,
                AppRoomDataBase::class.java,
                AppRoomDataBase.DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}