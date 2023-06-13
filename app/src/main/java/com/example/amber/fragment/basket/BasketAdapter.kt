package com.example.amber.fragment.basket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemBasketBinding
import com.example.domain.model.Product

class BasketAdapter(val pos: (pos: Int) -> Unit, val btnClickSafe: (num: Int) -> Unit) :
    RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {
    private var list: List<Product> = listOf()

    fun addItem(items: List<Product>) {
        this.list = items as ArrayList<Product>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = ItemBasketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasketViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val model = list[position]
        holder.onBing(list[position])
        holder.binding.btnPlusItemBasket.setOnClickListener {
            model.quantity = (model.quantity.toInt() + 1).toString()
            holder.updateQuantity(model)
            btnClickSafe(model.quantity.toInt())
            pos(position)
        }

        holder.binding.btnMinusItemBasket.setOnClickListener {
            if (model.quantity.toInt() > 0) {
                model.quantity = (model.quantity.toInt() - 1).toString()
                holder.updateQuantity(model)
                btnClickSafe(model.quantity.toInt())
                pos(position)
            }
        }
    }

    inner class BasketViewHolder(val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBing(model: Product) {
            binding.tvBasketPriceItem.text = model.descriptionProduct
            binding.tvBasketTitleItem.text = "$ ${model.price}"
            binding.ratingBarBasketItem.rating = model.rating.toFloat()
            binding.tvBasketCountItem.text = model.quantity
            Glide.with(binding.imgBasketItem)
                .load(model.imageProduct)
                .into(binding.imgBasketItem)
        }

        fun updateQuantity(model: Product) {
            binding.tvBasketCountItem.text = model.quantity
        }

    }

}