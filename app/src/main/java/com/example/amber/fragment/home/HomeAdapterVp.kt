package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.ItemHomeVpBinding
import com.example.domain.model.AmberItem

class HomeAdapterVp() : ListAdapter<AmberItem, HomeAdapterVp.HomesViewHolder>(NotesCallback()) {

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
        }
    }

    class NotesCallback : DiffUtil.ItemCallback<AmberItem>() {
        override fun areItemsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem
    }
}