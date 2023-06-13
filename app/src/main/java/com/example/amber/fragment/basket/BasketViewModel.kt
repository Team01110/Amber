package com.example.amber.fragment.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import com.example.domain.usecase.GetProductsRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class BasketViewModel @Inject constructor(
//    private val getAllAmberUseCase: GetAllAmberUseCase,
//    private val getRecommenAmberUseCase: GetRecommenAmberUseCase,
    val getProductsRoom: GetProductsRoom
) : BaseViewModel() {

    private val repo: RepoBasket = RepoBasket()

    private var count = MutableLiveData<Int>()

    private val _getAllproduct = MutableStateFlow<UiState<List<Product>>>(UiState.Empty())
    val getAllproduct = _getAllproduct.asStateFlow()


    val counting = count.switchMap {
        repo.counting(it)
    }


    fun increment(countt: Int) {
        count.postValue(countt)
    }

    fun getAllProductss() {
        getProductsRoom().collectFlow(_getAllproduct)
    }
//    private val _amberState = MutableStateFlow<UiState<List<ProductItem>>>(UiState.Empty())
//    val amberState = _amberState.asStateFlow()
//
//    private val _RecommenState = MutableStateFlow<UiState<List<ProductItem>>>(UiState.Empty())
//    val recommenState = _RecommenState.asStateFlow()
//
//    fun amberUseCase() {
//        viewModelScope.launch(Dispatchers.IO) {
//            getAllAmberUseCase().collectFlow(_amberState)
//        }
//    }
//    fun RecommenAmberUseCase() {
//        viewModelScope.launch(Dispatchers.IO){
//            getRecommenAmberUseCase().collectFlow(_RecommenState)
//        }
//    }

}