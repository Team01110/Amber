package com.example.amber.fragment.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentProductBinding
import com.example.amber.databinding.FragmentProfileBinding
import com.example.amber.exseption.showToast
import com.example.amber.fragment.home.HomeFragment
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate){

    private val viewModel: ProductViewModel by viewModels()
    override fun setupRequest() {
        viewModel.productState.collectState(onLoading = {
        }, onError = {
        }, onSuccess = {
            showToast("Insert")
            controller.navigateUp()
        })
    }

    override fun initialize() {
        if (arguments != null){
            val product = requireArguments().getSerializable(HomeFragment.KEY_PRODUCT) as Product
            binding.tvTitle.text = product.titleProduct
            Glide.with(binding.ivProduct)
                .load(product.imageProduct)
                .into(binding.ivProduct)
            binding.tvPrice.text = product.price
            binding.ratingBar.rating = product.rating.toFloat()
            binding.tvKindOfObject.text = product.titleProduct
            binding.tvDesc.text = product.descriptionProduct
            binding.btnProductAdd.setOnClickListener{
                val bundle = Bundle()
                bundle.putSerializable(KEY_TO_BASKET, product)
                controller.navigate(R.id.basketFragment, bundle)
                viewModel.insertAllProduct(product)
            }
        }
    }


    companion object{
        const val KEY_TO_BASKET = "key.to.basket"
    }

}