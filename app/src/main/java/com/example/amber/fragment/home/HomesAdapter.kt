package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeVpBinding
import com.example.domain.model.AmberItem

class HomesAdapter() : ListAdapter<AmberItem, HomesAdapter.HomesViewHolder>(NotesCallback()) {

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
        fun bind(model: AmberItem) {
            binding.tvProdukt.text = model.description
            binding.tvSpeakers.text = model.title
            Glide.with(binding.imgItemHome)
                .load(model.image)
                .into(binding.imgItemHome)
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<AmberItem>() {
        override fun areItemsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem
    }
}