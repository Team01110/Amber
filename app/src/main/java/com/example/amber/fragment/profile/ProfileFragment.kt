package com.example.amber.fragment.profile

import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentProfileBinding
import com.example.amber.exseption.showToast
import com.example.amber.fragment.home.HomeFragment
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override fun initialize() {
        val user = firebaseAuth.currentUser
        if (user == null) {
            findNavController().navigate(R.id.loginFragment)
        } else {
            binding.tvName.text = user.displayName
            binding.email.text = user.email
        }

    }

    override fun listeners() {
        binding.tvProfileAboutUs.setOnClickListener{
            controller.navigate(R.id.aboutUsFragment)
        }
        binding.tvProfileBasket.setOnClickListener{
            controller.navigate(R.id.basketFragment)
        }
        binding.tvProfileHelp.setOnClickListener{
            controller.navigate(R.id.supportFragment)
        }
    }


}