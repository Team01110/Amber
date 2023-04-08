package com.example.amber.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amber.fragment.utils.UiState
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {

    protected fun <T> Flow<ResultStatus<T>>.collectFlow(state: MutableStateFlow<UiState<T>>) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is ResultStatus.Error -> state.value = UiState.Error(it.error)
                    is ResultStatus.Loading -> state.value = UiState.Loading()
                    is ResultStatus.Success -> if (it.data != null) state.value =
                        UiState.Success(it.data)
                }
            }
        }
    }
}