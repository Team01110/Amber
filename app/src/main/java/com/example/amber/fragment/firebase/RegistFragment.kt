package com.example.amber.fragment.firebase

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentRegistBinding
import com.example.amber.exseption.showToast
import com.google.firebase.auth.FirebaseAuth


class RegistFragment :
    BaseFragment<FragmentRegistBinding, Any?>(FragmentRegistBinding::inflate) {

    val vm: RegistrViewModel by lazy {
        ViewModelProvider(requireActivity())[RegistrViewModel::class.java]
    }

    private lateinit var firebaseAuth: FirebaseAuth


    override fun initialize() {
        firebaseAuth = FirebaseAuth.getInstance()

    }

    override fun listeners() {

        binding.tvIfAccount.setOnClickListener {
            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val name = binding.nickName.text.toString()

            val bundle = Bundle()
            bundle.putString("key", "value")

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("foirf")
                            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
                        } else {
                            showToast(it.exception.toString())
                        }
                    }
            } else {
                showToast("please write something")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            findNavController().navigate(R.id.action_registFragment_to_homeFragment)
        }
    }


}