package com.example.amber.fragment.home

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.ProductItem
import com.example.domain.usecase.GetAllAmberUseCase
import com.example.domain.usecase.GetRecommenAmberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
@HiltViewModel
class HomeViewModel( private val getAllAmberUseCase: GetAllAmberUseCase,
                     private val getRecommenAmberUseCase: GetRecommenAmberUseCase
):BaseViewModel() {

    private val _getListItem = MutableStateFlow<UiState<List<ProductItem>>>(UiState.Empty())
    val getListItem = _getListItem.asStateFlow()

    private val _recommentState = MutableStateFlow<UiState<List<ProductItem>>>(UiState.Empty())
    val recommentState = _recommentState.asStateFlow()

    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
           getAllAmberUseCase().collectFlow(_getListItem)
        }
    }

    fun recommentAmberUseCase() {
        viewModelScope.launch(Dispatchers.IO){
            getRecommenAmberUseCase().collectFlow(_recommentState)
        }
    }


}