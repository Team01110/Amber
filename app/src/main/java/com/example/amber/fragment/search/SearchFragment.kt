package com.example.amber.fragment.search

import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentSearchBinding


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    override fun listeners() {
        binding.icClear.setOnClickListener {
            binding.edtSearch.text.clear()
        }
    }
}