package com.example.amber.fragment.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentBasketBinding
import com.example.domain.model.Category
import com.example.domain.model.Jewelery
import com.example.domain.model.Product


class BasketFragment() :
    BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {


    private lateinit var adapter: BasketAdapter
    private val viewModel: BasketViewModel by viewModels()

    private val num = 100
    override fun initialize() {
        viewModel.counting.observe(viewLifecycleOwner){
            binding.tvAllPrice.text = (num*it).toString()
        }
//        val list = mutableListOf<Jewelery>()
        val lists = mutableListOf<Product>()
//        lists.add(
//            Product(
//                "category",
//                "des",
//                a.toString(),
//                "4.5",
//                "ddd",
//        )
//        )
//        val listss = mutableListOf<Category>()
//        list.add(Jewelery(listss,lists))
        adapter = BasketAdapter(lists, viewModel)
        binding.rvBasket.adapter = adapter

    }

    override fun setupRequest() {
        viewModel.counting.observe(viewLifecycleOwner){
            binding.tvAllPrice.text = (num*it).toString()
        }
    }

    override fun listeners() {
        binding.btnArrow.setOnClickListener{
            controller.navigateUp()
        }
    }
}