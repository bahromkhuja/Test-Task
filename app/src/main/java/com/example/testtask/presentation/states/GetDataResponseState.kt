package com.example.testtask.presentation.states

import com.example.testtask.domain.DataResponse


data class GetDataResponseState(
    val isLoading: Boolean = false,
    var response: DataResponse? = null,
    val error: String = ""
)