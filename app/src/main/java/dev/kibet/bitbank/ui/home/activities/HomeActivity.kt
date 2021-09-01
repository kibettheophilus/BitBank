package dev.kibet.bitbank.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.ActivityHomeBinding
import dev.kibet.bitbank.ui.home.fragments.AddFragment


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomNav
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottomNav.setupWithNavController(navController = navController)

        //Hide bottom navigation when user selects new fragment
        navController?.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.sendFragment -> bottomNav.visibility = View.GONE
                R.id.addFragment -> bottomNav.visibility = View.GONE
                R.id.payFragment -> bottomNav.visibility = View.GONE
                R.id.withdrawFragment -> bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}