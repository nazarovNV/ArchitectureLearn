package com.example.architecturelearn.domain.usecase

import com.example.architecturelearn.domain.models.SaveUserNameParam
import com.example.architecturelearn.domain.repository.UserRepository


class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param : SaveUserNameParam) : Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) {
            return true
        }
        return userRepository.saveName(saveParam = param)
    }
}