package com.example.amber.fragment.home

import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import service.ApiService

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val vm: HomeViewModel by viewModels()
    private lateinit var adaptervp: HomeAdapter
    private lateinit var adapterrv: HomesAdapter
    private lateinit var api:ApiService

    override fun initialize() {
        binding.rvHome.adapter = adaptervp
        binding.rvHome2.adapter = adapterrv
        vm.amberUseCase()
    }


}