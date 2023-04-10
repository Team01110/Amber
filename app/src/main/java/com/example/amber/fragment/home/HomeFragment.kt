package com.example.amber.fragment.home

import androidx.fragment.app.viewModels
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentHomeBinding

class HomeFragment() :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val vm: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    private lateinit var adapter2: HomesAdapter

    override fun initialize() {
    }
}