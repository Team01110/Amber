package com.example.amber.fragment.basket

import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentBasketBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment() :
    BaseFragment<FragmentBasketBinding, Any?>(FragmentBasketBinding::inflate) {

    private lateinit var adapter: BasketAdapter

    override fun initialize() {
        //Тут мы получаем данные, так что тут не нужен viewmodel
    }

    override fun setupRequest() {
    }
}