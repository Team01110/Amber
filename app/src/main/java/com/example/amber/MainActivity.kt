package com.example.amber

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.amber.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var controller: NavController
    private lateinit var header: View
    private val firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        drawerLayout = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        val image = findViewById<ImageView>(R.id.all_groups)
        image.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as
                NavHostFragment
        controller = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.basketFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(controller, appBarConfiguration)
        binding.bottomBar.setupWithNavController(controller)


        controller.addOnDestinationChangedListener { _, _, _ ->
            if (controller.currentDestination?.id != R.id.homeFragment
            ) {
                image.visibility = View.GONE
            } else {
                image.visibility = View.VISIBLE
            }

        }
        if (!App.prefs.isShow()) {
            controller.navigate(R.id.onBoardFragment)
        }

        header = navigationView.getHeaderView(0)
        val user = firebaseAuth.currentUser
        val tvName = header.findViewById<TextView>(R.id.tv_nav_title)
        val tvEmail = header.findViewById<TextView>(R.id.tv_nav_email)

        if (user == null) {
            Toast.makeText(this, "You have not an account", Toast.LENGTH_SHORT).show()
        } else {
            tvName.text = user.displayName
            tvEmail.text = user.email
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}


