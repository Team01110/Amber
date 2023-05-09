package com.example.amber.fragment.firebase

import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentRegistBinding
import com.example.amber.exseption.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegistFragment : BaseFragment<FragmentRegistBinding>(FragmentRegistBinding::inflate) {

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




            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val name = binding.nickName.text.toString()
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build()

                        firebaseAuth.currentUser?.updateProfile(profileUpdates)
                            ?.addOnCompleteListener { _ ->
                            }

                        firebaseAuth.currentUser?.sendEmailVerification()
                            ?.addOnSuccessListener {
                                showToast("Ссылка отправлена на ваш email!")
                                findNavController().navigate(R.id.action_registFragment_to_loginFragment)
                            }?.addOnFailureListener {
                                showToast(it.toString())
                            }


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
            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
        }
    }


}