package com.example.tabtoolbarapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ScrollViewApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view_app)
    }

    fun seleccinaFruta(Vista: View){
        when(Vista.id){
            R.id.bananas-> Toast.makeText(this,"Son Bananas",Toast.LENGTH_SHORT).show()
            R.id.cerezas-> Toast.makeText(this,"Son cerezas",Toast.LENGTH_SHORT).show()
            R.id.frambuesas-> Toast.makeText(this,"Son frambuesas",Toast.LENGTH_SHORT).show()
            R.id.fresas-> Toast.makeText(this,"Son fresas",Toast.LENGTH_SHORT).show()
            R.id.kiwi-> Toast.makeText(this,"Son kiwi",Toast.LENGTH_SHORT).show()
            R.id.mango-> Toast.makeText(this,"Son mango",Toast.LENGTH_SHORT).show()
            R.id.manzana-> Toast.makeText(this,"Son manzana",Toast.LENGTH_SHORT).show()
            R.id.melon-> Toast.makeText(this,"Son melon",Toast.LENGTH_SHORT).show()
            R.id.naranjas-> Toast.makeText(this,"Son naranjas",Toast.LENGTH_SHORT).show()
            R.id.pera-> Toast.makeText(this,"Son peras",Toast.LENGTH_SHORT).show()
        }
    }
}