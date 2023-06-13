package com.example.amber.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val vm: HomeViewModel by viewModels()
    private val adapterRv: HomeAdapterRv by lazy { HomeAdapterRv(this::onClickProduct) }
    private val adapterVp: HomeAdapterVp by lazy { HomeAdapterVp() }

    private fun onClickProduct(product: Product) {
        val bundle = Bundle()
        bundle.putSerializable(KEY_PRODUCT, product)
        controller.navigate(R.id.action_homeFragment_to_productFragment, bundle)
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            vm.stateProduct.collect {
                when (it) {
                    is UiState.Error -> {
                        Log.e("ololo", "setupRequest:{${it.msg}}")
                        binding.notesBar.isVisible = false
                    }

                    is UiState.Loading -> {
                        binding.notesBar.isVisible = true
                    }

                    is UiState.Success -> {
                        binding.notesBar.isVisible = false
                        binding.rvHome2.adapter = adapterRv
                        adapterRv.submitList(it.data)
                    }
                    else -> {}
                }
            }
        }
        lifecycleScope.launch {
            vm.stateCategory.collect {
                when (it) {
                    is UiState.Error -> {
                        binding.notesBar.isVisible = false
                        Log.e("ololo", "setupRequest:{${it.msg}}")
                    }

                    is UiState.Loading -> { binding.notesBar.isVisible = true}

                    is UiState.Success -> {
                        binding.notesBar.isVisible = false
                        binding.rvHome.adapter = adapterVp
                        adapterVp.submitList(it.data)
                    }
                    else -> {}
                }
            }
        }

    }
    companion object{
        const val KEY_PRODUCT = "product"

    }
}