package com.example.architecturelearn.app

import android.app.Application
import com.example.architecturelearn.di.AppComponent
import com.example.architecturelearn.di.AppModule
import com.example.architecturelearn.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}