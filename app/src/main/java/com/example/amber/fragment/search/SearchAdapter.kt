package com.example.amber.fragment.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemHomeRvBinding
import com.example.domain.model.Product

class SearchAdapter(val click: (product: Product) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var list: ArrayList<Product> = arrayListOf()

    fun addList(list: List<Product>) {
        this.list = list as ArrayList<Product>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemHomeRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            click(list[position])
        }
    }

    inner class SearchViewHolder(private val binding: ItemHomeRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Product) {
            binding.tvItemTitleRv.text = model.titleProduct
            binding.tvPriceRvItem.text = "$ ${model.price}"
            Glide.with(binding.imgRvItem)
                .load(model.imageProduct)
                .into(binding.imgRvItem)
        }
    }
}