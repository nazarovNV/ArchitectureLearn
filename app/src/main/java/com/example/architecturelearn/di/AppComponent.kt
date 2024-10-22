package com.example.architecturelearn.di

import com.example.architecturelearn.app.App
import com.example.architecturelearn.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}