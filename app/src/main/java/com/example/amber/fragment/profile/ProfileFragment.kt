package com.example.amber.fragment.profile

import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override fun initialize() {
        val user = firebaseAuth.currentUser
        if (user == null) {
            findNavController().navigate(R.id.loginFragment)
        } else {
            binding.tvNameProfile.text = user.displayName
            binding.tvEmailProfile.text = user.email
        }

    }

    override fun listeners() {
        binding.tvAboutUsProfile.setOnClickListener {
            controller.navigate(R.id.aboutUsFragment)
        }
        binding.tvFavouritesProfile.setOnClickListener {
            controller.navigate(R.id.basketFragment)
        }
        binding.tvHelpSupportProfile.setOnClickListener {
            controller.navigate(R.id.supportFragment)
        }
    }


}