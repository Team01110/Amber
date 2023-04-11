package com.example.amber.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.HomeItemBinding
import com.example.amber.databinding.Item2HomeBinding
import com.example.domain.model.AmberItem

class HomeAdapter : ListAdapter<AmberItem, HomeAdapter.HomeViewHolder>(NotesCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = HomeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    inner class HomeViewHolder(private val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Model: AmberItem) {

        }
    }

    class NotesCallback : DiffUtil.ItemCallback<AmberItem>() {
        override fun areItemsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: AmberItem, newItem: AmberItem) =
            oldItem == newItem
    }
}
