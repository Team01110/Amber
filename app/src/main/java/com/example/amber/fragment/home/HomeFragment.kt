package com.example.amber.fragment.home

import androidx.fragment.app.Fragment

class HomeFragment : Fragment()
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