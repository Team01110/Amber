package com.example.amber.fragment.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amber.databinding.ItemBasketBinding
import com.example.domain.model.ItemModel
import com.example.domain.model.Product

class BasketAdapter(private val viewModel: BasketViewModel) : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {
    private var list: List<Product> = listOf<Product>()

    var conunt = 0

    private var num = 0


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
        holder.onBing(list[position])
    }

    inner class BasketViewHolder(private val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBing(model: Product) {
            binding.tvBasketPrice.text = model.descriptionProduct
            binding.tvBasketTitle.text = model.price
            binding.ratingBar.rating = model.rating.toFloat()
            Glide.with(binding.imgBasket)
                .load(model.imageProduct)
                .into(binding.imgBasket)

            binding.btnPlus.setOnClickListener {
                num++
                viewModel.increment(num)
                Pius(binding.btnPlus)


            }

            binding.btnMinus.setOnClickListener {
                num--
                viewModel.increment(num)
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