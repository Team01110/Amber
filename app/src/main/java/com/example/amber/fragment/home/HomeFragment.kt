package com.example.amber.fragment.home

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.exseption.showLog
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Category
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val vm: HomeViewModel by viewModels()
    private val adapterRv: HomeAdapterRv by lazy { HomeAdapterRv(this::onClickProduct) }
    private val adapterVp: HomeAdapterVp by lazy { HomeAdapterVp(this::onClickCategory) }

    private fun onClickProduct(product: Product) {
        val bundle = Bundle()
        bundle.putSerializable(KEY_PRODUCT, product)
        controller.navigate(R.id.action_homeFragment_to_productFragment, bundle)
    }

    private fun onClickCategory(category: Category) {
        val bundle = Bundle()
        bundle.putSerializable(KEY_CATEGORY, category)
        controller.navigate(R.id.categoryFragment, bundle)
    }

    override fun setupRequest() {


        lifecycleScope.launch {
            vm.stateProduct.collect {
                when (it) {
                    is UiState.Error -> {
                        showLog("setupRequest:{${it.msg}}")
                        vm.loading.value = false
                    }

                    is UiState.Loading -> {
                        vm.loading.value = true
                    }

                    is UiState.Success -> {
                        vm.loading.value = false
                        binding.rvProductsHome.adapter = adapterRv
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
                        showLog("setupRequest:{${it.msg}}")
                        vm.loading.value = false
                    }

                    is UiState.Loading -> {
                        vm.loading.value = true
                    }

                    is UiState.Success -> {
                        binding.vpHomeCategory.adapter = adapterVp
                        adapterVp.submitList(it.data)
                        vm.loading.value = false
                    }
                    else -> {}
                }
            }

        }

        vm.loading.observe(viewLifecycleOwner) {
            binding.progressBarHome.isVisible = true
            showLog("setupRequest:{${it}}")
        }
    }

    companion object {
        const val KEY_PRODUCT = "product"
        const val KEY_CATEGORY = "category"
    }
}