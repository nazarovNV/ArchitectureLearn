package com.example.architecturelearn.domain.usecase

import com.example.architecturelearn.domain.models.SaveUserNameParam


class SaveUserNameUseCase {
    fun execute(param : SaveUserNameParam) : Boolean {
        if (param.name.isEmpty()) {
            return false
        }
        else return true
    }
}