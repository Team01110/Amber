package com.example.amber.fragment.search

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentSearchBinding
import com.example.amber.exseption.showLog
import com.example.amber.fragment.home.HomeFragment
import com.example.amber.fragment.utils.UiState
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val adapter: SearchAdapter by lazy { SearchAdapter(this::onClickProduct) }
    private val vm: SearchViewModel by viewModels()
    private lateinit var listProduct: ArrayList<Product>
    override fun listeners() {

        view?.requestFocus()
        binding.searchView.requestFocus()

        binding.searchView.onFocusChangeListener = OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                val imm =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, 0)
            }
        }

        binding.searchView.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchText = binding.searchView.text.toString()
                searchQuery(searchText)
                true
            } else {
                false
            }
        }

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString()
                searchQuery(searchText)
            }

        })


    }

    override fun setupRequest() {
        lifecycleScope.launch {
            vm.stateProduct.collect {
                when (it) {
                    is UiState.Error -> {
                        showLog("setupRequest:{${it.msg}}")
                    }
                    is UiState.Success -> {
                        binding.rvSearch.adapter = adapter
                        listProduct = it.data as ArrayList<Product>
                        adapter.addList(listProduct)
                    }
                    else -> {}
                }
            }
        }
    }

    private fun onClickProduct(product: Product) {
        val bundle = Bundle()
        bundle.putSerializable(HomeFragment.KEY_PRODUCT, product)
        controller.navigate(R.id.productFragment, bundle)
    }

    private fun searchQuery(query: String?) {
        val list: ArrayList<Product> = arrayListOf()
        for (item in listProduct) {
            if (item.titleProduct.lowercase(Locale.ROOT).contains(query.toString())) {
                list.add((item))
            }
            if (item.titleProduct.uppercase(Locale.ROOT).contains(query.toString())) {
                list.add((item))
            }
            if (item.titleProduct.contains(query.toString())) {
                list.add((item))
            }
        }
        adapter.addList(list)
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT < 11) {
            binding.searchView.clearFocus();
            binding.searchView.requestFocus();
        }
    }


}