package com.example.architecturelearn.domain.repository

import com.example.architecturelearn.domain.models.SaveUserNameParam
import com.example.architecturelearn.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam : SaveUserNameParam) : Boolean
    fun getName() : UserName
}