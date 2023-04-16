package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.ItemHomeRvBinding
import com.example.domain.model.ProductItem

class HomeAdapterRv : ListAdapter<ProductItem, HomeAdapterRv.HomeViewHolder>(NotesCallback()) {

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
        fun bind(model: ProductItem) {
            binding.itemTvItemTitleRv.text = model.title
            binding.itemTvPriceRv.text = model.price.toString()

            Glide.with(binding.itemImgRv)
                .load(model.image)
                .into(binding.itemImgRv)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
            oldItem == newItem
    }
}
