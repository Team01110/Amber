package com.example.amber.fragment.home

import androidx.lifecycle.viewModelScope
import com.example.amber.base.BaseViewModel
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.AmberItem
import com.example.domain.usecase.GetAllAmberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
@HiltViewModel
class HomeViewModel(private val getAllAmberUseCase:GetAllAmberUseCase):BaseViewModel() {

    private val _getListItem = MutableStateFlow<UiState<List<AmberItem>>>(UiState.Empty())
    val getListItem = _getListItem.asStateFlow()

    fun amberUseCase() {
        viewModelScope.launch(Dispatchers.IO) {
           getAllAmberUseCase().collectFlow(_getListItem)
        }
    }
}