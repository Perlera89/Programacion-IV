package com.example.sqlliveapp

import android.content.ContentValues
import android.content.Intent
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

            db.insert("articles", null, article)
            db.close()

            etnCodigo.text.clear()
            etDescripcion.text.clear()
            etnPrecio.text.clear()

            Toast.makeText(this, "Se ha insertado correctamente",Toast.LENGTH_SHORT).show()

        } else{
            Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun buscar(view: View){
        // Se crea la conexion a la BD
        val admin =AdminSqLite(this,"Shop", null, version = 1)
        val db:SQLiteDatabase =admin.writableDatabase

        val id = etnCodigo.text.toString()

        if(id.isNotEmpty()){
            val fila = db.rawQuery("select description, price from articles where id = $id", null)
            if(fila.moveToFirst()){
                etDescripcion.setText(fila.getString(0))
                etnPrecio.setText(fila.getString(1))
                db.close()
            } else
                Toast.makeText(this,"No existe el articulo con id = $id", Toast.LENGTH_SHORT).show()
            db.close()
        } else {
            Toast.makeText(this,"Ingresa un codigo", Toast.LENGTH_SHORT).show()
        }
    }

    fun modificar(view: View){
        // Se crea la conexion a la BD
        val admin =AdminSqLite(this,"Shop", null, version = 1)
        val db:SQLiteDatabase =admin.writableDatabase

        val id = etnCodigo.text.toString()
        val description = etDescripcion.text.toString()
        val price = etnPrecio.text.toString()

        if(id.isNotEmpty() && description.isNotEmpty() && price.isNotEmpty()){
            val registro = ContentValues()
//            registro.put("id", id)
            registro.put("description", description)
            registro.put("price", price)

            val cantidad: Int = db.update("articles", registro, "id = $id", null)
            db.close()
            
            if(cantidad == 1) {
                Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show()

            etnCodigo.text.clear()
            etDescripcion.text.clear()
            etnPrecio.text.clear()

            Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show()
    }

    fun eliminar(view: View){
        // Se crea la conexion a la BD
        val admin =AdminSqLite(this,"Shop", null, version = 1)
        val db:SQLiteDatabase =admin.writableDatabase

        var id = etnCodigo.text.toString()

        if(id.isNotEmpty()){
            var cantidad: Int = db.delete("articles", "id = $id", null)
            db.close()
            etnCodigo.text.clear()

            if(cantidad == 1){
                Toast.makeText(this, "Articulo eliminado correctamente", Toast.LENGTH_SHORT).show()
            }
        } else Toast.makeText(this, "Debes ingresar un codigo", Toast.LENGTH_SHORT).show()
    }

    fun siguiente(view: View){
        val ventana: Intent = Intent(applicationContext, SharedPreferenceApp::class.java)
        startActivity(Intent(ventana))
    }
}