package com.example.gridcardviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private lateinit var gvTabla: GridView
    var nombre = arrayListOf<String>("Manuel", "Wilian", "Carlos")
    var departamento = arrayListOf<String>("Chalatenango", "Santa Ana", "Morazan")
    var imagen = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )
    var imagesLista = arrayOf(
        ImgItems(nombre.get(0), imagen.get(0), departamento.get(0)),
        ImgItems(nombre.get(1), imagen.get(1), departamento.get(1)),
        ImgItems(nombre.get(2), imagen.get(2), departamento.get(2))
    )

    var myImagenLista = arrayListOf<ImgItems>()
    var adaptador: AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(imagen in imagesLista){
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gvTabla)
        adaptador = AdaptadorModificado(myImagenLista, this)
        gvTabla.adapter = adaptador
        gvTabla.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                var ventana: Intent = Intent(this, DetallesActivity::class.java)
            }
        }
    }
}