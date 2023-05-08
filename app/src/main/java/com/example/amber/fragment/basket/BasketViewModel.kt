package com.example.amber.fragment.basket

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.ProductItem
import com.example.domain.usecase.GetAllAmberUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BasketViewModel(
    private val getAllAmberUseCase: GetAllAmberUseCase,
) : BaseViewModel() {

    private val _amberState = MutableStateFlow<UiState<List<ProductItem>>>(UiState.Empty())
    val amberState = _amberState.asStateFlow()

    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllAmberUseCase().collectFlow(_amberState)
        }
    }
}