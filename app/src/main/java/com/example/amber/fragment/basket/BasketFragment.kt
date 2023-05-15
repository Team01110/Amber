package com.example.amber.fragment.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentBasketBinding


class BasketFragment() :
    BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {

    private lateinit var adapter: BasketAdapter

    override fun initialize() {

//        val list = mutableListOf<ProductItem>()
//        list.add(ProductItem(
//                "category",
//                "des",
//                1,
//                "image",
//                1.1,
//                "title",
//                Ratings(3, 3.5)
//            ))
//        adapter = BasketAdapter(list)
//        binding.rvBasket.adapter = adapter
        //Тут мы получаем данные, так что тут не нужен viewmodel
    }

    override fun setupRequest() {
    }
}