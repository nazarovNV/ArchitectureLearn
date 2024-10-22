package com.example.architecturelearn.di

import com.example.architecturelearn.domain.usecase.GetUserNameUseCase
import com.example.architecturelearn.presentation.MainViewModel
import org.koin.core.module.dsl.viewModel

import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}