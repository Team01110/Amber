package com.example.amber.fragment.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemCategoryProductsBinding
import com.example.domain.model.Product


class CategoryAdapter(val click: (product: Product) -> Unit, val list: List<Product>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            click(list[position])
        }
    }

    class CategoryViewHolder(val binding: ItemCategoryProductsBinding) : ViewHolder(binding.root) {
        fun onBind(product: Product) {
            Glide.with(binding.imgCategoryItem)
                .load(product.imageProduct)
                .into(binding.imgCategoryItem)
            binding.tvTitleCategoryItem.text = product.titleProduct
            binding.ratingBarCategoryItem.rating = product.rating.toFloat()
            binding.tvPriceCategoryItem.text = "$ ${product.price}"
        }

    }
}