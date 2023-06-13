package com.example.amber.fragment.search

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import com.example.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : BaseViewModel() {


    private val _stateProduct = MutableStateFlow<UiState<List<Product>>>(UiState.Loading())
    val stateProduct = _stateProduct.asStateFlow()


    init {
        getProductsForSearch()
    }

    private fun getProductsForSearch() {

        viewModelScope.launch {
            getProductsUseCase().collectFlow(_stateProduct)
        }

    }
}