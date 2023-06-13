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
        binding.tvRegisterSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
        }

        binding.btnSignUpRegister.setOnClickListener {
            val email = binding.edEmilRegister.text.toString()
            val password = binding.edPasswordRegister.text.toString()
            val name = binding.edNicknameRegister.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && binding.checkBoxConfidential.isChecked) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {

                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .build()

                            firebaseAuth.currentUser?.updateProfile(profileUpdates)

                            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
                        } else {
                            showToast(it.exception.toString())
                        }
                    }
            } else {
                showToast("Вы не докончили заполнение")
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