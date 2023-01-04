package com.example.testtask.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.DataResponse
import com.example.testtask.domain.GetDataUseCase
import com.example.testtask.presentation.states.GetDataResponseState
import com.example.testtask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
): ViewModel(){

    private val _stateData = mutableStateOf(GetDataResponseState())
    val stateData: State<GetDataResponseState> = _stateData

    fun getData(){
        getDataUseCase.invoke().onEach { result: Resource<DataResponse> ->
            when (result){
                is Resource.Success -> {
                    try {
                        val response: DataResponse? = result.data
                        _stateData.value = GetDataResponseState(response = response)
                        Log.e("DataResponse", "DataResponse->\n ${_stateData.value}")
                    }catch (e: Exception) {
                        Log.d("Exception", "${e.message} Exception")
                    }
                }
                is Resource.Error -> {
                    Log.e("DataResponse", "DataResponseError->\n ${result.message}")
                    _stateData.value = GetDataResponseState(
                        error = "${result.message}"
                    )
                }
                is Resource.Loading -> {
                    _stateData.value = GetDataResponseState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}