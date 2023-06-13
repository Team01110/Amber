package com.example.amber.fragment.category

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentCategoryBinding
import com.example.amber.fragment.home.HomeFragment
import com.example.domain.model.Category
import com.example.domain.model.Product

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {


    override fun initialize() {
        if (arguments != null) {
            val category = requireArguments().getSerializable(HomeFragment.KEY_CATEGORY) as Category
            Glide.with(binding.imgCategoryCardView)
                .load(category.imageCategory)
                .into(binding.imgCategoryCardView)
            binding.tvTitleCategoryCard.text = category.titleCategory
            val adapter = CategoryAdapter(this::onClickProduct, category.items)
            binding.rvCategory.adapter = adapter
        }
    }

    private fun onClickProduct(product: Product) {
        val bundle = Bundle()
        bundle.putSerializable(HomeFragment.KEY_PRODUCT, product)
        controller.navigate(R.id.productFragment, bundle)
    }
}