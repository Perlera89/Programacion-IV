package com.example.funcionesclases

class Estudiante(val nombre: String, var edad: Int, var lenguajes: Array<lenguas>, val amigos: Array<Estudiante>? = null) {
    enum class lenguas{
        KOTLIN, PHP, JAVA, C, PYTHON
    }

    fun codigo(){
        for(lengua in lenguas.values()){
            println("Los lenguajes que conozco son:\n$lengua")
        }
    }

    fun saludar(){
        println("Hola soy $nombre")
    }
}