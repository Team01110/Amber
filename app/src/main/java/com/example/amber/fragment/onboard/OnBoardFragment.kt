package com.example.amber.fragment.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.amber.App
import com.example.amber.R
import com.example.amber.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint

class OnBoardFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isShow: Boolean = App.prefs.isShow()
        if (isShow) {
            findNavController().navigate(R.id.launchFragment)
        }

        App.prefs.changePreference()
        onBoard()
    }

    private fun onBoard() {
        val list = ArrayList<OnBoardModel>()
        list.add(OnBoardModel(R.drawable.bc_first_image, "Welcome to Amber!", "Description"))
        list.add(OnBoardModel(R.drawable.bc_second_image, "Title", "Description"))
        list.add(OnBoardModel(R.drawable.bc_third_image, "Title", "Description"))
        val boardAdapter = OnBoardAdapter(list, this)
        binding.viewPager.adapter = boardAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    override fun btnClick() {
        findNavController().navigate(R.id.launchFragment)
    }

}