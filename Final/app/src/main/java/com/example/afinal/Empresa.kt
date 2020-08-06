package com.example.afinal

class Empresa(
    var nombre:String,
    var color:String,
    var nivel:Int,
    var activo: Boolean,
    var listaEntrenadores:String) {
    override fun toString(): String {
        return "Empresa: ${nombre} ,Dirección: ${color}  "
    }

}