package com.example.drawerbottomviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    private lateinit var bnvMenu: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        bnvMenu = findViewById(R.id.bnv_menu)
        var homeFragment = HomeFragment()
        var messageFragment = MessageFragment()
        var perfilFragment = PerfilFragment()

        setFragment(homeFragment)
        bnvMenu.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.bottom_home -> {
                    setFragment(homeFragment)
                }

                R.id.bottom_message -> {
                    setFragment(messageFragment)
                }

                R.id.bottom_profile -> {
                    setFragment(perfilFragment)
                }
            }
        }
    }

    private fun setFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.frame_layout, fragment)
        commit()
    }
}