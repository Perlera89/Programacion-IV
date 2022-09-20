package com.example.internasanidadascalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etnValor1: EditText
    lateinit var etnValor2: EditText
    lateinit var txtResultado: TextView
    lateinit var rbSuma: RadioButton
    lateinit var rbResta: RadioButton
    lateinit var rbMultiplicacion: RadioButton
    lateinit var rbDivision: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etnValor1 = findViewById(R.id.etnValor1)
        etnValor2 = findViewById(R.id.etnValor2)
        txtResultado = findViewById(R.id.txtResultado)

        rbSuma = findViewById(R.id.rbSuma)
        rbResta = findViewById(R.id.rbResta)
        rbMultiplicacion = findViewById(R.id.rbMulti)
        rbDivision = findViewById(R.id.rbDiv)

//        claseInternaAnidada()
    }

    private fun claseInternaAnidada(){
        val claseAnidada = ClaseAnidadaInterna.ClaseAnidada()
        val sumaAnidada = claseAnidada.suma(4,1)
        println("El resultado de la suma es: $sumaAnidada")

        val claseInterna = ClaseAnidadaInterna().ClaseInterna()
        val sumaInterna = claseInterna.suma(1)
        println("El resultado de la suma + 1 es: $sumaInterna")
    }

    private fun Calcular(v: View){
        var valor1String = (etnValor1.text.toString()).toInt()
        var valor2String = (etnValor2.text.toString()).toInt()

        if(rbSuma.isChecked){
            val resultado = valor2String + valor2String
            txtResultado.setText(resultado.toString())
        } else if(rbResta.isChecked){
            val resultado = valor2String - valor2String
            txtResultado.setText(resultado.toString())
        } else if(rbMultiplicacion.isChecked){
            val resultado = valor2String * valor2String
            txtResultado.setText(resultado.toString())
        } else if(rbDivision.isChecked){
            if(valor2String != 0){
                val resultado = valor2String / valor2String
                txtResultado.setText(resultado.toString())
            } else {
                Toast.makeText(this, "No puede dividir por un valor 0", Toast.LENGTH_LONG).show()
            }
        }
    }
}