package com.example.amber.fragment.product

import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import com.example.domain.usecase.AddProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val createNoteUseCase: AddProductUseCase,
) : BaseViewModel() {


    private val _productState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val productState = _productState.asStateFlow()

    fun insertAllProduct(product: Product) {
        createNoteUseCase(
            Product(
                titleProduct = product.titleProduct,
                descriptionProduct = product.descriptionProduct,
                imageProduct = product.imageProduct,
                price = product.price,
                rating = product.rating,
                quantity = product.quantity
            )
        ).collectFlow(_productState)
    }
}