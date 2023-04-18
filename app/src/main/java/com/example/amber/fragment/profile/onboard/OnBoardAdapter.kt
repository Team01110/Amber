package com.example.amber.fragment.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.amber.databinding.ItemOnBoardBinding
import java.util.*

class OnBoardAdapter(
    private val list: ArrayList<OnBoardModel>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        return holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(onBoardModel: OnBoardModel) {
            binding.imageView.setImageResource(onBoardModel.image)
            binding.tvTitle.text = onBoardModel.title
            binding.tvDesc.text = onBoardModel.desc

            if (adapterPosition == list.size - 1) {
                binding.btnStart.isVisible = true
            }

            binding.btnStart.setOnClickListener {
                listener.btnClick()
            }
        }
    }
}