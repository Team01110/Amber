package com.example.amber.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.ItemModel
import com.example.domain.model.Product
import com.example.domain.usecase.GetProductsUseCase
import com.example.domain.utils.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Product>>>(UiState.Loading())
    val state = _state.asStateFlow()

    init {
        amberUseCase()
    }
    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
            getProductsUseCase().collect() { ItemModel ->
                when (ItemModel) {
                    is ResultStatus.Success -> {
                        _state.value = UiState.Success(ItemModel.data?.map { it })
                    }

                    is ResultStatus.Loading -> {
                        _state.value = UiState.Loading()
                    }

                    is Error -> {
                        _state.value = UiState.Error(msg = ItemModel.message ?: "Error")
                    }

                    else -> {
                        _state.value = UiState.Error(msg = ItemModel.error ?: "Error")
                    }
                }
            }
        }
    }
}
