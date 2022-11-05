package com.example.tabtoolbarapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var vpVistaPager :ViewPager2
    private lateinit var vlVistaTabla:TabLayout

    private val adaptador by lazy{
        vpAdaptador(this)
    }

    private val adaptador2 = vpAdaptador(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpVistaPager = findViewById(R.id.vp_VistaPager)
        vlVistaTabla = findViewById(R.id.tl_VistaTablero)

        vpVistaPager.adapter = adaptador

        val medidorTabla = TabLayoutMediator(vlVistaTabla,vpVistaPager,
        TabLayoutMediator.TabConfigurationStrategy({
            tab, position ->
            when(position){
                0 ->{
                    tab.text = "Opcion 1"
                    tab.setIcon(R.drawable.ic_imagen1)
                    val badge:BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                    badge.isVisible


                }
                1 ->{
                    tab.text = "Opcion 2"
                    tab.setIcon(R.drawable.ic_imagen2)
                    val badge:BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                    badge.number = 17
                    badge.isVisible
                }
                2 ->{
                    tab.text = "Opcion 3"
                    tab.setIcon(R.drawable.ic_imagen3)
                    val badge:BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.miColor)
                    badge.number = 100
                    badge.maxCharacterCount = 3
                    badge.isVisible
                }
            }
        }))
        medidorTabla.attach()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.miContactos -> {
                Toast.makeText(this,"has seleccionado contactos",Toast.LENGTH_SHORT).show()
            }
            R.id.miFavorito -> {
                Toast.makeText(this,"has seleccionado favorito",Toast.LENGTH_SHORT).show()
            }
            R.id.miConfiguracion -> {
                Toast.makeText(this,"has seleccionado configuracion",Toast.LENGTH_SHORT).show()
            }
            R.id.miNActividad -> {
                //Toast.makeText(this,"has seleccionado nueva actividad",Toast.LENGTH_SHORT).show()
                val ventana = Intent(applicationContext,ScrollViewApp::class.java)
                startActivity(ventana)
            }
            R.id.miCerrar -> {
                finish()
            }

        }
        return true
    }


}