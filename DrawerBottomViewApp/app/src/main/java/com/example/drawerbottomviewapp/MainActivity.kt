package com.example.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var nav: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.drawer_layout)
        nav = findViewById(R.id.nav_vista)
        toogle = ActionBarDrawerToggle(this, drawer, R.string.open_drawer, R.string.close_drawer)

        toogle?.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista, HomeFragment())
                        commit()
                    }
                }

                R.id.nav_camera -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista, CameraFragment())
                        commit()
                    }
                }

                R.id.nav_galery -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista, GaleryFragment())
                        commit()
                    }
                }

                R.id.nav_message -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista, MessageFragment())
                        commit()
                    }
                }
            }

            drawer.closeDrawer((GravityCompat.START))
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}