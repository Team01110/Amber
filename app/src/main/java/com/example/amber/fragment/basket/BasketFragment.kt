package com.example.amber.fragment.basket

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentBasketBinding
import com.example.amber.exseption.showLog
import com.example.amber.exseption.showToast
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment :
    BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {


    private lateinit var list: List<Product>
    private lateinit var adapter: BasketAdapter
    private val viewModel: BasketViewModel by viewModels()

    override fun setupRequest() {
        viewModel.getAllProducts()
        viewModel.getAllProduct.collectState(onLoading = {
            viewModel.loading.value = true
        }, onError = {
            showToast(it)
            viewModel.loading.value = false
        }, onSuccess = { list ->
            adapter.addItem(list)
            this.list = list
            viewModel.loading.value = false

        })
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBarBasket.isVisible = it
            showLog("setupRequest:{${it}}")
        }
    }

    private fun getPositionForCount(pos: Int) {
        val product = list[pos]
        var totalPrice: Double
        viewModel.counting.observe(viewLifecycleOwner) {
            totalPrice = (product.descriptionProduct.toFloat() * it).toDouble()
            binding.tvBasketTotalPrice.text = totalPrice.toString()
        }
    }

    private fun btnClickSafe(num: Int) {
        viewModel.changeCount(num)
    }


    override fun initialize() {

        adapter = BasketAdapter(this::getPositionForCount, this::btnClickSafe)
        binding.rvBasket.adapter = adapter

    }
}