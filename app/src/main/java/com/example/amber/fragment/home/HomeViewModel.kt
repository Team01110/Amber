package com.example.amber.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Category
import com.example.domain.model.ItemModel
import com.example.domain.model.Product
import com.example.domain.usecase.GetCategoryUseCase
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
    private val getCategoryUseCase: GetCategoryUseCase,
) : ViewModel() {

    private val _stateProduct = MutableStateFlow<UiState<List<Product>>>(UiState.Loading())
    val stateProduct = _stateProduct.asStateFlow()

    private val _stateCategory = MutableStateFlow<UiState<List<Category>>>(UiState.Loading())
    val stateCategory = _stateCategory.asStateFlow()

    init {
        amberUseCase()
    }
    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
            getProductsUseCase().collect() { ItemModel ->
                when (ItemModel) {
                    is ResultStatus.Success -> {
                        _stateProduct.value = UiState.Success(ItemModel.data?.map { it })
                    }

                    is ResultStatus.Loading -> {
                        _stateProduct.value = UiState.Loading()
                    }

                    is Error -> {
                        _stateProduct.value = UiState.Error(msg = ItemModel.message ?: "Error")
                    }

                    else -> {
                        _stateProduct.value = UiState.Error(msg = ItemModel.error ?: "Error")
                    }
                }
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            getCategoryUseCase().collect() { Category ->
                when (Category) {
                    is ResultStatus.Success -> {
                        _stateCategory.value = UiState.Success(Category.data?.map { it })
                    }

                    is ResultStatus.Loading -> {
                        _stateCategory.value = UiState.Loading()
                    }

                    is Error -> {
                        _stateCategory.value = UiState.Error(msg = Category.message ?: "Error")
                    }

                    else -> {
                        _stateCategory.value = UiState.Error(msg = Category.error ?: "Error")
                    }
                }
            }
        }
    }
}
