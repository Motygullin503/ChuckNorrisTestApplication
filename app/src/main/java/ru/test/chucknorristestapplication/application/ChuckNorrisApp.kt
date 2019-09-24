package ru.test.chucknorristestapplication.application

import android.app.Application
import ru.test.chucknorristestapplication.di.component.AppComponent
import ru.test.chucknorristestapplication.di.component.DaggerAppComponent
import ru.test.chucknorristestapplication.di.module.NetworkModule

class ChuckNorrisApp: Application() {

    private lateinit var app: ChuckNorrisApp
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule("https://api.chucknorris.io"))
            .build()
    }

    fun getInstance(): ChuckNorrisApp {
        return app
    }
}