package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_empleados.*

class ListaEmpleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empleados)
        val lista_pokemones= BddService.listaPokemones


        val adaptador= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            lista_pokemones)

        lv_lista_pokemones.adapter=adaptador

        lv_lista_pokemones.onItemClickListener= AdapterView.OnItemClickListener{
                parent,view,position,id ->
            Log.i("list-view","Posicion ${lista_pokemones[position]}")
           // irEntrenador(position);
        }

        btn_ir_empresas.setOnClickListener {
            irEntrenador()
        }






    }
    fun irEntrenador(){
        val intentExplicito= Intent(this, EmpleadoActivity::class.java)
      //  intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }


}