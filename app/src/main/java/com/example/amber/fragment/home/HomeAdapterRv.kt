package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeRvBinding
import com.example.domain.model.Product

class HomeAdapterRv : ListAdapter<Product, HomeAdapterRv.HomeViewHolder>(NotesCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    inner class HomeViewHolder(private val binding: ItemHomeRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Product) {
            binding.itemTvItemTitleRv.text = model.titleProduct
            binding.itemTvPriceRv.text = model.price
            Glide.with(binding.itemImgRv)
                .load(model.imageProduct)
                .into(binding.itemImgRv)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Product, newItem: Product) =
            oldItem == newItem
    }
}