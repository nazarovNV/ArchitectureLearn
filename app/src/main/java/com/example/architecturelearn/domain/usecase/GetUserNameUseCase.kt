package com.example.architecturelearn.domain.usecase

import com.example.architecturelearn.domain.models.UserName

class GetUserNameUseCase {
    fun execute() : UserName {
        return UserName("Vladimir", "Ivanov")
    }
}