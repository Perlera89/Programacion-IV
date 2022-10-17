package com.example.sqlliveapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etnCodigo: EditText
    private lateinit var etDescripcion:EditText
    private lateinit var etnPrecio:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etnCodigo = findViewById(R.id.etnId)
        etDescripcion = findViewById(R.id.etDescription)
        etnPrecio = findViewById(R.id.etnPrice)
    }

    fun registrar(view: View){

        // Se crea la conexion a la BD
        val admin =AdminSqLite(this,"Shop", null, version = 1)
        val db:SQLiteDatabase =admin.writableDatabase



        val id = etnCodigo.text.toString()
        val description = etDescripcion.text.toString()
        val price = etnPrecio.text.toString()

        if(!id.isEmpty() &&!description.isEmpty()){
            val article = ContentValues()
            article.apply {
                this.put("id",id)
                this.put("description",description)
                this.put("price", price)
            }

            db.insert("article", null, article)
            db.close()

            etnCodigo.text.clear()
            etDescripcion.text.clear()
            etnPrecio.text.clear()

            Toast.makeText(this, "Se ha insertado correctamente",Toast.LENGTH_SHORT).show()

        } else{
            Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}