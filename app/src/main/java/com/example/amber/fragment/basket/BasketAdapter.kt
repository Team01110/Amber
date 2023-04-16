package com.example.amber.fragment.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemBasketBinding
import com.example.domain.model.ProductItem

class BasketAdapter : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    private val list: List<ProductItem> = ArrayList()
    private var conunt = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = ItemBasketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasketViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.onBing(list[position])
    }

    inner class BasketViewHolder(private val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBing(model: ProductItem) {
            binding.tvBasketPrice.text = model.price.toString()
            binding.tvBasketReview.text = model.description
            binding.tvBasketTitle.text = model.title
            Glide.with(binding.imgBasket)
                .load(model.image)
                .into(binding.imgBasket)

            binding.btnPlus.setOnClickListener {
                Pius(binding.btnPlus)
            }

            binding.btnMinus.setOnClickListener {
                Minus(binding.btnMinus)
            }
        }

        fun Pius(view: View) {
            conunt += 1
            display(conunt)
        }

        fun Minus(view: View) {
            conunt -= 1
            display(conunt)
        }

        private fun display(number: Int) {
            binding.tvBasketCount.text = "" + number
        }
    }
}