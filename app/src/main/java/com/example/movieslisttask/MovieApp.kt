package com.example.movieslisttask

import android.app.Application
import com.example.movieslisttask.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by alexkorolov on 21/06/2020.
 */
class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            modules(appModule)
        }
    }
}