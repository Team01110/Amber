package com.example.amber.fragment.onboard

import android.os.Bundle
import android.view.View
import com.example.amber.App
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentOnBoardBinding

class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(FragmentOnBoardBinding::inflate),
    ItemClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.prefs.changePreference()
        onBoard()
    }

    private fun onBoard() {
        val boardAdapter = OnBoardAdapter(requireContext(), this)
        binding.viewPagerOnboard.adapter = boardAdapter
        binding.dotsIndicatorOnboard.attachTo(binding.viewPagerOnboard)
    }

    override fun clickOnButton() {
        controller.navigate(R.id.launchFragment)
    }

}