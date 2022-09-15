package com.example.funcionesclases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //LLamando funcion
        // arrays()
        // seguridadNula()
        //funciones()
        clases()
    }

    fun arrays() {
        val nombre = "Carlos"
        val apellido = "Benitez"
        val departamento = "Chalatenango"
        val edad = "24"

        //Crear el arreglo
        val miArreglo = arrayListOf<String>()

        //agregar los datos
        miArreglo.add(nombre)
        miArreglo.add(apellido)
        miArreglo.add(departamento)
        //miArreglo.add(edad.toString())
        miArreglo.add(edad)

        println(miArreglo)


        //Agregar conjunto  de datos
        miArreglo.addAll(listOf("Estudiantes", "Programacion IV"))
        println(miArreglo)


        //Acceder datos de arrays, debemos mandar a llamar
        var miDepart = miArreglo[2]
        println(miDepart)
        println(miArreglo[5])

        //Modificar dato dentro del arreglo
        miArreglo[0] = "Kemberly"
        println(miArreglo[0])

        //eliminar datos
        miArreglo.removeAt(2)
        println(miArreglo)


        //recorrer el arreglo
        miArreglo.forEach {

            //it "este elemento"
            println(it)

        }
        //otras operaciones
        println(miArreglo.count())
        miArreglo.clear()
        println(miArreglo.count())
    }

    //Seguridad contra nulos(null safety)
    fun seguridadNula() {
        var miString: String = "Programacion IV 13/09/2022"
        //miString = null; Esto daria error de compilacion
        println(miString)


        //variable, seguridad nula (null safety)
        //simbolo interrogacion permite agregar valores nulos
        var miSeguridadNula: String? = "valor de seguridad nula"
        miSeguridadNula = null
        println(miSeguridadNula)


        miSeguridadNula = "Le volvemos a dar un valor"
        //println(miSeguridadNula)

        if (miSeguridadNula != null) {
            println(miSeguridadNula.toString()!!) //!! gaerantizar q no es nulo el valor

        }else{
            println(miSeguridadNula.toString())

        }

        println(miSeguridadNula?.length)
        miSeguridadNula?.let {
            println(it.toString())
        }?: kotlin.run{
            println(miSeguridadNula)
        }
    }


    fun funciones() {
        decirHola()
        decirHola()
        decirHola()

        decirNombre("Manuel")
        decirNombre("Catalina")

        decirNombreyEdad("Ari",21)

        var sumResultado = sumarDosNum(9,8)
        println(sumResultado)

        println(sumarDosNum(4,2))

        println(sumarDosNum(1,sumarDosNum(1,3)))

    }
    //funcion simple
    fun decirHola(){

        println("Hola Estudiante")
    }

    //funcion con parametros de entrada
    fun decirNombre(nombre:String){
        println("Hola tu nombre es $nombre")

    }
    fun decirNombreyEdad(nombre:String, edad:Int){
        println("Hola tu nombre es $nombre y tu edad es $edad")

    }

    fun sumarDosNum(num1:Int, num2:Int):Int{
        val suma = num1+num2
        return suma
    }

    fun clases(){
        val cata = Estudiante("Kemberly", 24, arrayOf(Estudiante.lenguas.JAVA, Estudiante.lenguas.KOTLIN))
        println(cata.nombre)
        cata.edad = 23

        val marcos = Estudiante("Antonio", 23, arrayOf(Estudiante.lenguas.PHP, Estudiante.lenguas.C), arrayOf(cata))
        println(marcos.codigo())

        println("${marcos.amigos?.first()?.nombre} es amiga de ${marcos.nombre}")
    }
}