package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.ItemHomeRvBinding
import com.example.domain.model.AmberItem

class HomeAdapterRv : ListAdapter<AmberItem, HomeAdapterRv.HomeViewHolder>(NotesCallback()) {

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
