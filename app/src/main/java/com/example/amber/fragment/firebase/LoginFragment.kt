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

    lateinit var vm: LoginViewModel

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                handleResults(task)
//            }
//        }

    override fun initialize() {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.app_name)).requestEmail().build()

        googleSignInClient = requireContext().let { GoogleSignIn.getClient(it, gso) }

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun listeners() {

        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else {
                        showToast(it.exception.toString())

                    }
                }
            } else {
                showToast("Empty Fields Are not Allowed !!")

            }
        }

//        binding.gSignBtn.setOnClickListener {
//            signInGoogle()
//        }

        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast("working")
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                    } else {
                        showToast(it.exception.toString())
                    }
                }
            } else {
                showToast("please write something")
            }
        }
    }
//
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
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

}