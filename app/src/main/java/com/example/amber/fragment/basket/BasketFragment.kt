package com.example.amber.fragment.basket

import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentBasketBinding
import com.example.amber.exseption.showToast
import com.example.amber.fragment.product.ProductFragment
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment() :
    BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {


    private lateinit var adapter: BasketAdapter
    private val viewModel: BasketViewModel by viewModels()

    override fun setupRequest() {
        viewModel.getAllProductss()
        viewModel.getAllproduct.collectState(onLoading = {
        }, onError = {
            showToast(it)
        }, onSuccess = {
            adapter.addItem(it)
        })
    }

    override fun initialize() {


        if (arguments != null) {
            val product =
                requireArguments().getSerializable(ProductFragment.KEY_TO_BASKET) as Product
            viewModel.counting.observe(viewLifecycleOwner) {
                binding.tvAllPrice.text = (product.price.toInt() * it).toString()
            }
        }


        adapter = BasketAdapter(viewModel)
        binding.rvBasket.adapter = adapter

    }

    override fun listeners() {
        binding.btnArrow.setOnClickListener {
            controller.navigateUp()
        }
    }
}