package com.example.amber.fragment.firebase

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.databinding.FragmentLoginBinding
import com.example.note.presentation.extencion.showToast
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val verification = firebaseAuth.currentUser?.isEmailVerified
                        if (verification == true) {

                            findNavController().navigate(R.id.launchFragment)
                        }else{
                            showToast("Ссылка была отправлена на ваш email!")
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
}