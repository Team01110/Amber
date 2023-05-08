package com.example.amber.fragment.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.exseption.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, Any?>(FragmentHomeBinding::inflate) {
    private val vm: HomeViewModel by viewModels()
    private lateinit var adapterRv: HomeAdapterRv
    private lateinit var adapterVp: HomeAdapterVp

    override fun initialize() {
        adapterRv = HomeAdapterRv()
        adapterVp = HomeAdapterVp()
        binding.rvHome.adapter = adapterRv
        binding.rvHome2.adapter = adapterVp
        vm.amberUseCase()
    }

    override fun setupRequest() {
        vm.getListItem.collectState(onLoading = {
         binding.notesBar.isVisible = true
        }, onSuccess = {
            adapterVp.submitList(it)
            binding.notesBar.isVisible = false
        }, onError = {
            showToast(it)
            binding.notesBar.isVisible = false
        })
    }
}