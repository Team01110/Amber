package com.example.amber.fragment.basket

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.base.BaseViewModel
import com.example.amber.databinding.FragmentBasketBinding
import com.example.amber.exseption.ShowTost
import com.example.amber.fragment.home.HomeAdapter

class BasketFragment() :
    BaseFragment<BasketViewModel, FragmentBasketBinding>(FragmentBasketBinding::inflate) {

    override val vm: BasketViewModel by viewModels()
    private lateinit var adapter: BasketAdapter

    override fun initialize() {
        vm.amberUseCase()
    }

    override fun setupRequest() {
        vm.amberState.collectState(onLoading = {

        }, onSuccess = {
            binding.rvBasket.adapter = adapter
        }, onError = {
            ShowTost(it)

        })
    }
}