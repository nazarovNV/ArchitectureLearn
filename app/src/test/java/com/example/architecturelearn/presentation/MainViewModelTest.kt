package com.example.architecturelearn.presentation

import com.example.architecturelearn.domain.models.SaveUserNameParam
import com.example.architecturelearn.domain.usecase.GetUserNameUseCase
import com.example.architecturelearn.domain.usecase.SaveUserNameUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class MainViewModelTest {
    private val getUserNameUseCase = mock<GetUserNameUseCase>()
    private val saveUserNameUseCase = mock<SaveUserNameUseCase>()
    private lateinit var viewModel: MainViewModel

    @BeforeEach
    fun beforeEach() {
        viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserNameUseCase)
        Mockito.reset(saveUserNameUseCase)
    }


    @Test
    fun `should save username and return true`() {
        val testSaveText = "Test user name"
        val saveResult = true

        val testParams = SaveUserNameParam(name = testSaveText)

        Mockito.`when`(saveUserNameUseCase.execute(param = testParams)).thenReturn(saveResult)


        viewModel.save(text = testSaveText)

        val expected = "Save result = true"
        val actual = viewModel.resultLive.value

        Mockito.verify(saveUserNameUseCase, times(numInvocations = 1)).execute(param = testParams)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should save username and return false`() {

    }

    @Test
    fun `should load username`() {

    }
}