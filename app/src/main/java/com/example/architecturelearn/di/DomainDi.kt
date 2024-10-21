package com.example.architecturelearn.di

import com.example.architecturelearn.domain.usecase.GetUserNameUseCase
import com.example.architecturelearn.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}

