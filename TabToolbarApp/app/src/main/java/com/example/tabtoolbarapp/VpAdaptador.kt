package com.example.tabtoolbarapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpAdaptador(fa: FragmentActivity): FragmentStateAdapter(fa){
    companion object {
        private const val ARG_OBJECT = "object"
    }

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragmento = VIstaFragmento()
        fragmento.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }

        return fragmento
    }
}