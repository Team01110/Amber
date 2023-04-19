package com.example.amber.fragment.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.R
import com.example.amber.databinding.ItemOnBoardBinding
import java.util.*

class OnBoardAdapter(
    val myContext: Context,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val listImg = listOf(R.drawable.bc_first_image,R.drawable.bc_second_image, R.drawable.bc_third_image)
    private val listTitle = listOf(R.string.welcome, R.string.convenient_management, R.string.variety_of_goods)
    private val listDesc = listOf(R.string.the_best_products,R.string.dev_management, R.string.buy_goods)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return listTitle.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.imageView.setImageResource(listImg[position])
            binding.tvTitle.text = myContext.getString(listTitle[position])
            binding.tvDesc.text = myContext.getString(listDesc[position])

            if (adapterPosition == listTitle.size - 1) {
                binding.btnStart.isVisible = true
            }

            binding.btnStart.setOnClickListener {
                listener.btnClick()
            }
        }
    }
}