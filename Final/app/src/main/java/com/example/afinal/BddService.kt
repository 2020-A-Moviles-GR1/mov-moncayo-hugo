package com.example.afinal

class BddService {
    companion object{

        var listaPokemones= arrayListOf<Empleado>(
            Empleado("Viviana","A", "1200"),
            Empleado("Maritza","B","1250"),
            Empleado("Helena","C","1000")
        )
        var listaEntrenadores= arrayListOf<Empresa>(
            Empresa(
                "Arkilit",
                "Sosaya",
                2158065,
                true,
                "Helena"
            )
        )
        fun buscar_pokemon(chord:String): Empleado? {


            var pokemon_encontrado=listaPokemones.find{
                    pokemon -> pokemon.nombre
                .equals(chord.toLowerCase())||pokemon.division.equals(chord.toLowerCase()) }
            return pokemon_encontrado
        }
        fun obtener_pokemon(posicion: Int):Empleado{
            return listaPokemones.get(posicion);
        }

        fun buscar_entrenador(chord:String): Empresa? {
            var entrenador_encontrado= listaEntrenadores.find{
                    entrenador -> entrenador.nombre
                .equals(chord.toLowerCase())||entrenador.color.equals(chord.toLowerCase()) }
            return entrenador_encontrado
        }
        fun agregar_entrenador(empresa:Empresa){
            listaEntrenadores.add(empresa)
        }
        fun eliminar_entrendor(empresa: Empresa){
            listaEntrenadores.remove(empresa)

        }
        fun modificar_empresa(posicion:Int, empresa: Empresa){
            listaEntrenadores.set(posicion,empresa);
        }
        fun obtener_entrenador(posicion: Int):Empresa{
            return listaEntrenadores.get(posicion);
        }
        fun modificar_pokemon(posicion:Int, empleado: Empleado){
            listaPokemones.set(posicion,empleado);
        }


    }
}