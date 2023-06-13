package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeVpBinding
import com.example.domain.model.Category

class HomeAdapterVp(val click: (category: Category) -> Unit) :
    ListAdapter<Category, HomeAdapterVp.HomeViewHolder>(NotesCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeVpBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            click(getItem(position))
        }
    }

    inner class HomeViewHolder(private val binding: ItemHomeVpBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Category) {
            binding.tvTitleVpItem.text = model.titleCategory
            binding.tvCountVpItem.text = "Товаров 4"
            Glide.with(binding.imgItemVp)
                .load(model.imageCategory)
                .into(binding.imgItemVp)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Category, newItem: Category) =
            oldItem == newItem
    }
}