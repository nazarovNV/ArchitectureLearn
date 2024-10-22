package com.example.architecturelearn.di

import android.content.Context
import com.example.architecturelearn.data.repository.UserRepositoryImpl
import com.example.architecturelearn.data.storage.UserStorage
import com.example.architecturelearn.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturelearn.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context : Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }
}