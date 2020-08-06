package com.example.afinal

class Empleado(
    var nombre:String,
    var division:String,
    var nivel: String

     ) {
    override fun toString(): String {
        return "Empleado: ${nombre}, ${division} "
    }

}