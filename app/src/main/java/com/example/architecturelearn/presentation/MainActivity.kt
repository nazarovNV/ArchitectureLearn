package com.example.architecturelearn.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.architecturelearn.R
import com.example.architecturelearn.data.repository.UserRepositoryImpl
import com.example.architecturelearn.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.architecturelearn.domain.models.SaveUserNameParam
import com.example.architecturelearn.domain.models.UserName
import com.example.architecturelearn.domain.usecase.GetUserNameUseCase
import com.example.architecturelearn.domain.usecase.SaveUserNameUseCase

class MainActivity : Activity() {
    private val sharedPrefUserStorage by lazy(LazyThreadSafetyMode.NONE) {
        SharedPrefUserStorage(context = applicationContext)
    }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {


        UserRepositoryImpl(userStorage = sharedPrefUserStorage)
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val param = SaveUserNameParam(text)
            val result: Boolean = saveUserNameUseCase.execute(param)
            dataTextView.text = "Save result = $result"

        }
        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"

        }
    }
}