package com.example.amber.fragment.firebase

import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentLoginBinding
import com.example.amber.exseption.showToast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class LoginFragment :
    BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient


    override fun initialize() {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.app_name)).requestEmail().build()

        googleSignInClient = requireContext().let { GoogleSignIn.getClient(it, gso) }

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun listeners() {

        binding.tvCreateAccLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }

        binding.btnSignInLogin.setOnClickListener {
            val email = binding.edEmailLogin.text.toString()
            val pass = binding.edPasswordLogin.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else {
                        showToast(it.exception.toString())

                    }
                }
            } else {
                showToast("Вы не докончили заполнение")

            }
        }

        binding.tvCreateAccLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }
    }


    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

}