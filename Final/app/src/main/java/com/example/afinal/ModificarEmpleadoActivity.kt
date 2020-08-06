package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_modificar_empleado.*

class ModificarEmpleadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_empleado)
        val posicion_entrenador= intent.getIntExtra("posicon_entrenador", -1)
       val posicion= intent.getIntExtra("posicion_pokemon", -1)
        val nombrellega : String? = intent.getStringExtra("nombre_pokemon")
        val tipollega : String? = intent.getStringExtra("tipo_pokemon")
        val nivelllega : String? = intent.getStringExtra("nivel_pokemon")
        Log.i("list-view","posicion recibido ${posicion}")
        val Entrenador_dueno=BddService.obtener_entrenador(posicion_entrenador)
        val pokemon_encontrado=BddService.buscar_pokemon(nombrellega.toString())
        if(pokemon_encontrado!=null){
            Log.i("list-view","Empleado $pokemon_encontrado")
            //Modificar Pokemon

            etv_nombre_empleado_mod.setText(nombrellega)
            etv_empleado_area.setText(tipollega)
            et_salario_empleado_Ed.setText(nivelllega)

        }else{
            Toast.makeText(applicationContext,"No se encuentra empleado", Toast.LENGTH_SHORT).show()
        }
        btn_modificar_pokemon.setOnClickListener {
            BddService.modificar_pokemon(posicion, Empleado (
                etv_nombre_empleado_mod.text.toString(),
                etv_empleado_area.text.toString(),
                et_salario_empleado_Ed.text.toString()
            ))
            Toast.makeText(applicationContext,"empleado Modificado",Toast.LENGTH_SHORT).show()
            ir_list_pokemones()
        }
        btn_eliminar_pokemon.setOnClickListener {
          
            Toast.makeText(applicationContext,"Empleado Eliminado",Toast.LENGTH_SHORT).show()
            ir_list_pokemones()
        }
    }
    fun ir_list_pokemones(){
        val intentExplicito= Intent(this, ListaEmpleados::class.java)
        this.startActivity(intentExplicito)
    }
    fun ir_activity_pokemones(){
        val intentExplicito= Intent(this, EmpleadoActivity::class.java)
        //    intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
}