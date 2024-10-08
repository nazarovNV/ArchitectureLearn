package com.example.architecturelearn.domain.usecase

import com.example.architecturelearn.domain.models.UserName
import com.example.architecturelearn.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository : UserRepository) {
    fun execute() : UserName {
        return userRepository.getName()
    }
}