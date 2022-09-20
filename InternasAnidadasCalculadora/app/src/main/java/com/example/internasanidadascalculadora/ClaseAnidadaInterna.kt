package com.example.internasanidadascalculadora

class ClaseAnidadaInterna {
//    Es una clase que puede estar dentro de otra clase

    private val uno = 1

    private fun retornaUno(): Int{
        return uno
    }

//    Nested class
    class ClaseAnidada{
        fun suma(n1: Int, n2: Int): Int{
            return n1 + n2
        }
    }

//    Inner class
    inner class ClaseInterna{
        fun suma(n1: Int): Int{
            return n1 + uno + retornaUno()
        }
    }
}