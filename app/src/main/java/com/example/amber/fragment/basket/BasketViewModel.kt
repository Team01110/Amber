package com.example.amber.fragment.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import com.example.domain.usecase.GetProductsRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    val getProductsRoom: GetProductsRoom
) : BaseViewModel() {

    private val _getAllProduct = MutableStateFlow<UiState<List<Product>>>(UiState.Empty())
    val getAllProduct = _getAllProduct.asStateFlow()

    private var countLiveData = MutableLiveData<Int>()


    val counting = countLiveData.switchMap {
        getCount(it)
    }

    fun getAllProducts() {
        getProductsRoom().collectFlow(_getAllProduct)
    }

    fun changeCount(count: Int) {
        countLiveData.postValue(count)
    }

    private fun getCount(count: Int): LiveData<Int> {
        val livedata = MutableLiveData<Int>()
        livedata.value = count
        return livedata
    }

}