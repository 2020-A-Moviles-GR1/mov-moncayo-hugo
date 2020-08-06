package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_empresa.*

class AgregarEmpresaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_empresa)
        val posicion= intent.getIntExtra("index",-1)

        if(posicion>-1){
            //Me enviaron para modificar
            tv_ag_mod_tipo.text="Modificar Empresa"
            btn_agregar_modificar.setText("MODIFICAR")
            var empresa:Empresa= BddService.obtener_entrenador(posicion)
            et_nombre.setText(empresa.nombre)
            et_cdireccion.setText(empresa.color)
            et_telefono.setText(empresa.nivel.toString())
            et_empresa_activo.setText(empresa.activo.toString())
            et_empleados.setText(empresa.listaEntrenadores)
            btn_agregar_modificar.setOnClickListener {
                BddService.modificar_empresa(posicion, Empresa(
                    et_nombre.text.toString(),
                    et_cdireccion.text.toString(),
                    et_telefono.text.toString().toInt(),
                    et_empresa_activo.text.toString().toBoolean(),
                    et_empleados.text.toString()
                ))
                Toast.makeText(applicationContext,"Empresa Modificada",Toast.LENGTH_SHORT).show()
                ir_entrenador(posicion)
            }

        }else{
            tv_ag_mod_tipo.text="Agregar Nueva Empresa"
            btn_agregar_modificar.setText("AGREGAR")
            //Me enviaron para agregar
            btn_agregar_modificar.setOnClickListener {
                BddService.agregar_entrenador(Empresa(
                    et_nombre.text.toString(),
                    et_cdireccion.text.toString(),
                    et_telefono.text.toString().toInt(),
                    et_empresa_activo.text.toString().toBoolean(),
                    et_empleados.text.toString()
                ))
                Toast.makeText(applicationContext,"Empresa Agregada",Toast.LENGTH_SHORT).show()
                ir_lista_entrenadores()
            }
        }
        btn_agregar_a_lista.setOnClickListener {
            this.startActivity(Intent(this,ListaEmpresasActivity::class.java))
        }
        btn_agregar_a_main.setOnClickListener {
            this.startActivity(Intent(this,MainActivity::class.java))
        }
    }
    fun ir_entrenador(posicion:Int){
        val intentExplicito= Intent(this, EmpleadoActivity::class.java)
        intentExplicito.putExtra("index",posicion)
        this.startActivity(intentExplicito)
    }
    fun ir_lista_entrenadores(){
        val intentExplicito= Intent(this, ListaEmpresasActivity::class.java)
        this.startActivity(intentExplicito)
    }

}