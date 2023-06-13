import com.example.amber.R
import com.example.amber.base.BaseFragment
import com.example.amber.databinding.FragmentLaunchBinding
import com.google.firebase.auth.FirebaseAuth

class LaunchFragment : BaseFragment<FragmentLaunchBinding>(FragmentLaunchBinding::inflate) {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun initialize() {
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun listeners() {
        binding.btnLoginLaunch.setOnClickListener {
            controller.navigate(R.id.loginFragment)
        }
        binding.btnRegisterLaunch.setOnClickListener {
            controller.navigate(R.id.registFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            controller.navigate(R.id.homeFragment)
        }

    }

}
