package com.example.amber

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.amber.databinding.ActivityMainBinding
import com.example.amber.fragment.internet.InternetConnection
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController
    private lateinit var header: View
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigations()

        val checkConnection = InternetConnection(this)
        checkConnection.observe(this) { isConnected ->
            if (!isConnected) {
                controller.navigate(R.id.connectionFragment)
            }
        }

        if (!App.prefs.isShow()) {
            controller.navigate(R.id.onBoardFragment)
        }
    }

    private fun setupNavigations() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as
                NavHostFragment
        controller = navHostFragment.navController

        binding.navView.setNavigationItemSelectedListener(this)

        val toggle =
            ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_nav, R.string.close_nav)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navView.setCheckedItem(R.id.nav_home)


        binding.allGroups.setOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }
        controller.addOnDestinationChangedListener { _, _, _ ->
            if (controller.currentDestination?.id != R.id.homeFragment
            ) {

                binding.allGroups.visibility = View.GONE
            } else {
                binding.allGroups.visibility = View.VISIBLE
            }

            if (controller.currentDestination?.id == R.id.launchFragment ||
                controller.currentDestination?.id == R.id.onBoardFragment ||
                controller.currentDestination?.id == R.id.registFragment ||
                controller.currentDestination?.id == R.id.connectionFragment ||
                controller.currentDestination?.id == R.id.loginFragment

            ) {
                binding.bottomBar.visibility = View.GONE
            } else {
                binding.bottomBar.visibility = View.VISIBLE
            }

            header = binding.navView.getHeaderView(0)
            val user = firebaseAuth.currentUser
            val tvName = header.findViewById<TextView>(R.id.tv_nav_title)
            val tvEmail = header.findViewById<TextView>(R.id.tv_nav_email)

            if (user != null) {
                tvName.text = user.displayName
                tvEmail.text = user.email
            }
        }

        binding.bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> controller.navigate(R.id.homeFragment)
                R.id.searchFragment -> controller.navigate(R.id.searchFragment)
                R.id.basketFragment -> controller.navigate(R.id.basketFragment)
                R.id.profileFragment -> controller.navigate(R.id.profileFragment)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> controller.navigate(R.id.homeFragment)
            R.id.nav_search -> controller.navigate(R.id.searchFragment)
            R.id.nav_basket -> controller.navigate(R.id.basketFragment)
            R.id.nav_profile -> controller.navigate(R.id.profileFragment)
            R.id.nav_about -> controller.navigate(R.id.aboutUsFragment)
            R.id.nav_help -> controller.navigate(R.id.supportFragment)
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}