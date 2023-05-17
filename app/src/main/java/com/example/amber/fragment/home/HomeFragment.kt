package com.example.amber.fragment.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding
import com.example.amber.exseption.showToast
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){


}
//    BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
//    override val vm: HomeViewModel by viewModels()
//    private lateinit var adapterRv: HomeAdapterRv
//    private lateinit var adapterVp: HomeAdapterVp
//
//    override fun initialize() {
//        adapterRv = HomeAdapterRv()
//        adapterVp = HomeAdapterVp()
//        binding.rvHome.adapter = adapterRv
//        binding.rvHome2.adapter = adapterVp

        //Error
//        vm.amberUseCase()
//        vm.recommentAmberUseCase()
//    }
//
//    override fun setupRequest() {

        //Error
//        vm.getListItem.collectState(onLoading = {
//         binding.notesBar.isVisible = true
//        }, onSuccess = {
//            adapterVp.submitList(it)
//            binding.notesBar.isVisible = false
//        }, onError = {
//            showToast(it)
//            binding.notesBar.isVisible = false
//        })
//
//        vm.recommentState.collectState(onLoading = {
//            binding.notesBar.isVisible = true
//        }, onSuccess = {
//            adapterRv.submitList(it)
//            binding.notesBar.isVisible = false
//        }, onError = {
//            showToast(it)
//            binding.notesBar.isVisible = false
//        })
//    }
//}