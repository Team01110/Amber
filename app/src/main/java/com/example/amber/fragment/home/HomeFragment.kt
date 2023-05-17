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
class HomeFragment : BaseFragment<FragmentHomeBinding, Any?>(FragmentHomeBinding::inflate) {
    private val vm: HomeViewModel by viewModels()
    private val adapterVp: HomeAdapterRv by lazy { HomeAdapterRv() }
    private val adapterRv: HomeAdapterVp by lazy { HomeAdapterVp() }

    override fun setupRequest() {
        lifecycleScope.launch {
            vm.state.collect {
                when (it) {
                    is UiState.Error -> {
                        Log.e("ololo", "setupRequest:{${it.msg}}")
                    }

                    is UiState.Loading -> {}

                    is UiState.Success -> {
                        binding.rvHome.adapter = adapterRv
                        binding.rvHome2.adapter = adapterVp
                        adapterRv.submitList(it.data)
                        adapterVp.submitList(it.data)
                    }
                }
            }
        }
    }
}