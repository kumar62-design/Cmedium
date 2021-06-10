package com.example.cmedium

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.api.models.entities.User
import com.example.cmedium.databinding.ActivityMainBinding
import com.example.cmedium.ui.auth.AuthViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var authViewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        // All side navigation data
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_feed,
                R.id.nav_my_feed,
                R.id.nav_auth
            ), drawerLayout
        )

        // Bottom navigation setup and controller
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        authViewModel.user.observe({lifecycle}){
            updateMenu(it)
            navController.navigateUp()
            Toast.makeText(this,"Logged in as ${it?.username}", Toast.LENGTH_SHORT).show()
        }
    }

    // Upadating sidebar menu Login/Signup to logout and writing code for that
    private fun updateMenu(user: User?){
        when(user){
            is User -> {
                binding.navView.menu.clear()
                binding.navView.inflateMenu(R.menu.menu_main_user)
            }
            else -> {

            }
        }
    }

    // This is the side menu bar function using onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}