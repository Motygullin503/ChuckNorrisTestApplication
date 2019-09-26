package ru.test.chucknorristestapplication.application

import android.app.Application
import ru.test.chucknorristestapplication.di.component.AppComponent
import ru.test.chucknorristestapplication.di.component.DaggerAppComponent
import ru.test.chucknorristestapplication.di.module.NetworkModule

class ChuckNorrisApp: Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: ChuckNorrisApp

        fun getInstance(): ChuckNorrisApp {
            return instance
        }
    }

    private lateinit var app: ChuckNorrisApp
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule("https://api.chucknorris.io/jokes/"))
            .build()
    }


}