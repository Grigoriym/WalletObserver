package com.grappim.walletobserver.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.grappim.walletobserver.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.drawerLayout
import kotlinx.android.synthetic.main.activity_main.navigationView
import kotlinx.android.synthetic.main.activity_main.toolbar

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        appBarConfiguration = AppBarConfiguration(
          setOf(
            R.id.homeFragment,
            R.id.recordsFragment,
            R.id.debtsFragment,
            R.id.goalsFragment,
            R.id.shoppingListsFragment
          ), drawerLayout
        )

        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        drawerLayout.closeDrawers()
        return displaySelectedScreen(item.itemId)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun displaySelectedScreen(itemId: Int): Boolean {
        when (itemId) {
          R.id.nav_home -> navController.navigate(R.id.homeFragment)
          R.id.nav_records -> navController.navigate(R.id.recordsFragment)
          R.id.nav_debts -> navController.navigate(R.id.debtsFragment)
          R.id.nav_goals -> navController.navigate(R.id.goalsFragment)
          R.id.nav_shopping_lists -> navController.navigate(R.id.shoppingListsFragment)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
