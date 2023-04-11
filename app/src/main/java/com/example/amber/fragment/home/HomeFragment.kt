package com.example.amber.fragment.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.exseption.ShowTost

class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val vm: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    private lateinit var adapter2: HomesAdapter

    override fun initialize() {
        binding.rvHome.adapter = adapter
        binding.rvHome2.adapter = adapter2
        vm.amberUseCase()
    }

    override fun setupRequest() {
        vm.amberState.collectState(onLoading = {
         binding.notesBar.isVisible = true
        }, onSuccess = {
            adapter.submitList(it)
            adapter2.submitList(it)
            binding.notesBar.isVisible = false
        }, onError = {
            ShowTost(it)
            binding.notesBar.isVisible = false
        })
    }
}