package com.example.amber.fragment.internet

import androidx.navigation.fragment.findNavController
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentConnectionBinding

class ConnectionFragment :
    BaseFragment<FragmentConnectionBinding>(FragmentConnectionBinding::inflate) {

    override fun initialize() {
        super.initialize()
        val checkInternet = InternetConnection(requireContext())
        checkInternet.observe(this) { isConnected ->
            binding.btnTryAgain.setOnClickListener {
                if (isConnected) {
                    findNavController().navigateUp()
                }
            }
        }
    }
}
