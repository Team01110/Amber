package com.example.amber.fragment.basket

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.AmberItem
import com.example.domain.usecase.GetAllAmberUseCase
import com.example.domain.usecase.GetRecommenAmberUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BasketViewModel(
    private val getAllAmberUseCase: GetAllAmberUseCase,
    private val getRecommenAmberUseCase: GetRecommenAmberUseCase
) : BaseViewModel() {

    private val _amberState = MutableStateFlow<UiState<List<AmberItem>>>(UiState.Empty())
    val amberState = _amberState.asStateFlow()

    private val _RecommenState = MutableStateFlow<UiState<List<AmberItem>>>(UiState.Empty())
    val recommenState = _RecommenState.asStateFlow()

    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllAmberUseCase().collectFlow(_amberState)
        }
    }
    fun RecommenAmberUseCase() {
        viewModelScope.launch(Dispatchers.IO){
            getRecommenAmberUseCase().collectFlow(_RecommenState)
        }
    }

}