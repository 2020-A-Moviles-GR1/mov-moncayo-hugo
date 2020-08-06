package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_empresas.*

class ListaEmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_empresas)
        val listaEntrenadores= BddService.listaEntrenadores


        val adaptador= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaEntrenadores)

        lv_empresas.adapter=adaptador

        lv_empresas.onItemClickListener= AdapterView.OnItemClickListener{
                parent,view,position,id ->
            Log.i("list-view","Posicion ${listaEntrenadores[position]}")
            irEntrenador(position);
        }
        btn_lista_regresar.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }

        btn_crear_empresa.setOnClickListener {
            this.startActivity(Intent(this,AgregarEmpresaActivity::class.java))
        }





    }
    fun irEntrenador(posicion:Int){
        val intentExplicito= Intent(this, EmpleadoActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }


}