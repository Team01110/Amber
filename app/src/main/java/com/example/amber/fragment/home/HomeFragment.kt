package com.example.amber.fragment.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.exseption.ShowTost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val vm: HomeViewModel by viewModels()
    private lateinit var adaptervp: HomeAdapter
    private lateinit var adapterrv: HomesAdapter
    override fun initialize() {
        binding.rvHome.adapter = adaptervp
        binding.rvHome2.adapter = adapterrv
        vm.amberUseCase()
        vm.RecommenAmberUseCase()
    }
    override fun setupRequest() {
        vm.amberState.collectState(onLoading = {
            binding.amberBar.isVisible = true
        }, onSuccess = {
            adaptervp.submitList(it)
            binding.amberBar.isVisible = false
        }, onError = {
            ShowTost(it)
            binding.amberBar.isVisible = false
        })

       vm.recommenState.collectState(onLoading = {
           binding.amberBar.isVisible = true
       }, onSuccess = {
           adapterrv.submitList(it)
           binding.amberBar.isVisible = false
       }, onError = {
           ShowTost(it)
           binding.amberBar.isVisible = false
       })
    }


}