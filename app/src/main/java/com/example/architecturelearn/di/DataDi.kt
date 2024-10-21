package com.example.architecturelearn.di

import com.example.architecturelearn.data.repository.UserRepositoryImpl
import com.example.architecturelearn.data.storage.UserStorage
import com.example.architecturelearn.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturelearn.domain.repository.UserRepository
import org.koin.dsl.module

//private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//    UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
//}


val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}