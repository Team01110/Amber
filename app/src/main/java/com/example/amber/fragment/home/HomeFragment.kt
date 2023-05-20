package com.example.amber.fragment.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.fragment.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val vm: HomeViewModel by viewModels()
    private val adapterRv: HomeAdapterRv by lazy { HomeAdapterRv() }
    private val adapterVp: HomeAdapterVp by lazy { HomeAdapterVp() }

    override fun setupRequest() {
        lifecycleScope.launch {
            vm.stateProduct.collect {
                when (it) {
                    is UiState.Error -> {
                        Log.e("ololo", "setupRequest:{${it.msg}}")
                    }

                    is UiState.Loading -> {}

                    is UiState.Success -> {
                        binding.rvHome2.adapter = adapterRv
                        adapterRv.submitList(it.data)
                    }
                }
            }
        }
            lifecycleScope.launch {
                vm.stateCategory.collect {
                    when (it) {
                        is UiState.Error -> {
                            Log.e("ololo", "setupRequest:{${it.msg}}")
                        }

                        is UiState.Loading -> {}

                        is UiState.Success -> {
                            binding.rvHome.adapter = adapterVp
                            adapterVp.submitList(it.data)
                        }
                    }
                }
            }

    }
}