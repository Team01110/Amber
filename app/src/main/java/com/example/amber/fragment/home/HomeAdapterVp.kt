package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeVpBinding
import com.example.domain.model.ProductItem

class HomeAdapterVp() : ListAdapter<ProductItem, HomeAdapterVp.HomesViewHolder>(NotesCallback()) {

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
        fun bind(model: ProductItem) {
            binding.itemTvCountVp.text = model.rating.count.toString()
            binding.itemTvTitleVp.text = model.title
            Glide.with(binding.imgItemVp)
                .load(model.image)
                .into(binding.imgItemVp)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
            oldItem == newItem
    }
}