package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_empleado.*
import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast

class EmpleadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            var empresa : Empresa= BddService.obtener_entrenador(posicion)
            tv_empleado_empresa.setText("Entrenador: ${empresa.nombre} -Color: ${empresa.color}")
            val chords=empresa.listaEntrenadores.toString().split(",").toTypedArray()
            val adaptador= ArrayAdapter(this,android.R.layout.simple_list_item_1,chords)
            lv_empresas.adapter=adaptador

            lv_empresas.onItemClickListener= AdapterView.OnItemClickListener{
                    parent,view,position,id ->
                Log.i("list-view","Posicion ${chords[position]}")
                val empleado_encontrado=BddService.obtener_pokemon(position)
                Log.i("list-view","Empleado Encontrado ${empleado_encontrado}")
                if(empleado_encontrado!=null){
                    Log.i("empleado-econtrado","$empleado_encontrado")
                    //Modificar Pokemon

                    val intentExplicito= Intent(this, ModificarEmpleadoActivity::class.java)
                    intentExplicito.putExtra("posicon_entrenador", posicion)
                    intentExplicito.putExtra("posicion_pokemon", position)
                    intentExplicito.putExtra("nombre_pokemon", empleado_encontrado.nombre)
                    intentExplicito.putExtra("tipo_pokemon", empleado_encontrado.division)
                    intentExplicito.putExtra("nivel_pokemon", empleado_encontrado.nivel)

                    Log.i("list-view","Posicion eviado ${chords[position]}")
                    Log.i("list-view","tipo_empleado ${empleado_encontrado.division}")
                  // Log.i("list-view","nivel_pokemon ${pokemon_encontrado.nivel}")
                    this.startActivity(intentExplicito)                    
                }else{
                    Toast.makeText(applicationContext,"No hay empleado", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            this.startActivity(Intent(this,MainActivity::class.java))
        }
        btn_menu.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
        btn_acordes_a_lista.setOnClickListener {
            this.startActivity(Intent(this,ListaEmpresasActivity::class.java))
        }
    }
}