package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeVpBinding
import com.example.domain.model.Product

class HomeAdapterVp() : ListAdapter<Product, HomeAdapterVp.HomesViewHolder>(NotesCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomesViewHolder {
        val binding = ItemHomeVpBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomesViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    inner class HomesViewHolder(private val binding: ItemHomeVpBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Product) {
            binding.itemTvCountVp.text = model.rating
            binding.itemTvTitleVp.text = model.titleProduct
            Glide.with(binding.imgItemVp)
                .load(model.imageProduct)
                .into(binding.imgItemVp)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Product, newItem: Product) =
            oldItem == newItem
    }
}