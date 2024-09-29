package com.example.architecturelearn.data.storage

import com.example.architecturelearn.data.storage.models.User

interface UserStorage {
    fun save(user : User) : Boolean

    fun get(): User
}