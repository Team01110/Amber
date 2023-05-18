package com.example.amber.fragment.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.amber.App
import com.example.amber.R
import com.example.amber.databinding.FragmentOnBoardBinding

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
        App.prefs.changePreference()
        onBoard()
    }

    private fun onBoard() {
        val boardAdapter = OnBoardAdapter(requireContext(), this)
        binding.viewPager.adapter = boardAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    override fun btnClick() {
        findNavController().navigate(R.id.launchFragment)
    }

}