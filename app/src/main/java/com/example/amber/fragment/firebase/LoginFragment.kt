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


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

    //    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                handleResults(task)
//            }
//        }
    override fun listeners() {
        binding.tvIfAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }
        binding.signButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            val verification = firebaseAuth.currentUser?.isEmailVerified
                            if (verification == true) {
                                findNavController().navigate(R.id.profileFragment)
                            } else {
                                showToast("Ссылка была отправлена на ваш email!")
                            }
                        } else {
                            showToast("Authentication failed.")
                        }
                    }
            } else {
                showToast("please write something")
            }
        }
    }

    override fun initialize() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.app_name)).requestEmail().build()

        googleSignInClient = requireContext().let { GoogleSignIn.getClient(it, gso) }

        firebaseAuth = FirebaseAuth.getInstance()
    }

    // for google button

    //    override fun setupRequest() {
//        vm.amberState.collectState(onLoading = {
//            binding.progressBar.isVisible = true
//        }, onError = {
//            showToast("failed")
//            binding.progressBar.isVisible = false
//        }, onSuccess = {
//            binding.progressBar.isVisible = false
//        })
//    }

//    private fun signInGoogle() {
//        val signInIntent = googleSignInClient.signInIntent
//        launcher.launch(signInIntent)
//    }

//    private fun handleResults(task: Task<GoogleSignInAccount>) {
//        if (task.isSuccessful) {
//            val account: GoogleSignInAccount? = task.result
//            if (account != null) {
//                updateUI(account)
//            }
//        } else {
//            showToast(task.exception.toString())
//        }
//    }
//
//    private fun updateUI(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
//            if (it.isSuccessful) {
//                showToast("work")
//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//            } else {
//                showToast(it.exception.toString())
//
//            }
//        }
//    }


    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
        }
    }

}
