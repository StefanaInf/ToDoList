package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.fragments.*
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        replaceFragment(personalTasksFragment)
        val bottomNavigation : NavigationBarView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.show_calendar -> replaceFragment(calendarFragment)
                R.id.show_tasks -> replaceFragment(personalTasksFragment)
            }
            true
        }

        //Navigation Bar
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {

                R.id.nav_work -> {
                    Toast.makeText(applicationContext, "Work", Toast.LENGTH_SHORT).show()
                    replaceFragment(workTasksFragment)
                }
                R.id.nav_school -> {
                    Toast.makeText(applicationContext, "School", Toast.LENGTH_SHORT).show()
                    replaceFragment(schoolTasksFragment)
                }
                R.id.nav_personal -> {
                    Toast.makeText(applicationContext, "Personal", Toast.LENGTH_SHORT).show()
                    replaceFragment(personalTasksFragment)
                }
            }
            true
        }
    }

    private val personalTasksFragment = PersonalFragment()
    private val calendarFragment = CalendarFragment()
    private val workTasksFragment = WorkFragment()
    private val schoolTasksFragment = SchoolFragment()

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
