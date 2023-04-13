package com.example.amber.fragment.basket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.ItemBasketBinding
import com.example.domain.model.AmberItem

class BasketAdapter : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    private val list: List<AmberItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = ItemBasketBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasketViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.onBing(list[position])
    }

    class BasketViewHolder(private val biding: ItemBasketBinding) :
        RecyclerView.ViewHolder(biding.root) {
        fun onBing(amberItem: AmberItem) {

        }
    }
}