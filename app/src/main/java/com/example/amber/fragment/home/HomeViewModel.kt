package com.example.amber.fragment.home

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.domain.usecase.GetCategoryUseCase
import com.example.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : BaseViewModel() {

    private val _stateProduct = MutableStateFlow<UiState<List<Product>>>(UiState.Loading())
    val stateProduct = _stateProduct.asStateFlow()

    private val _stateCategory = MutableStateFlow<UiState<List<Category>>>(UiState.Loading())
    val stateCategory = _stateCategory.asStateFlow()


    init {
        getProductsAndCategory()
    }

    private fun getProductsAndCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            getProductsUseCase().collectFlow(_stateProduct)
        }
        viewModelScope.launch(Dispatchers.IO) {
            getCategoryUseCase().collectFlow(_stateCategory)
        }
    }
}
