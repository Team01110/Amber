package com.example.amber.fragment.firebase

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.amber.R
import com.example.amber.databinding.FragmentRegistBinding
import com.example.note.presentation.extencion.showToast
import com.google.firebase.auth.FirebaseAuth


class RegistFragment : Fragment() {
    private lateinit var binding: FragmentRegistBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistBinding.inflate(layoutInflater)

        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_registFragment_to_loginFragment)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val name = binding.nickName.text.toString()

            val bundle = Bundle()
            bundle.putString("key", "value")

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
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

