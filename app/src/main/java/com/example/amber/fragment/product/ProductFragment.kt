package com.example.amber.fragment.product

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentProductBinding
import com.example.amber.exseption.showToast
import com.example.amber.fragment.home.HomeFragment
import com.example.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate) {

    private val viewModel: ProductViewModel by viewModels()
    override fun setupRequest() {
        viewModel.productState.collectState(onLoading = {
        }, onError = {
        }, onSuccess = {
            showToast("Insert")
        })
    }

    override fun initialize() {
        if (arguments != null) {
            val product = requireArguments().getSerializable(HomeFragment.KEY_PRODUCT) as Product
            binding.tvTitleProduct.text = product.titleProduct
            Glide.with(binding.imgProduct)
                .load(product.imageProduct)
                .into(binding.imgProduct)
            binding.tvPriceProduct.text = product.price
            binding.ratingBarProduct.rating = product.rating.toFloat()
            binding.tvBottomTitleProduct.text = product.titleProduct
            binding.tvDescProduct.text = product.descriptionProduct


            binding.btnProductAdd.setOnClickListener {
                viewModel.insertAllProduct(product)
                val bundle = Bundle()
                bundle.putSerializable(KEY_TO_BASKET, product)
                controller.navigate(R.id.basketFragment, bundle)

            }

        }
    }

    override fun listeners() {
        super.listeners()
        binding.imgArrowBack.setOnClickListener {
            controller.navigateUp()
            showToast("Success")
        }
    }


    companion object {
        const val KEY_TO_BASKET = "key.to.basket"
    }

}