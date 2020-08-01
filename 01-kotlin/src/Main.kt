import java.util.*
import java.util.function.Consumer

fun main(args: Array<String>) {
    print("Hola")
    //int edad =31;
    //variables mutables e inmutables

    //inmutables no puedes volver a ser modifiables

    //MUTABLES var

    //mutable puede ser re declarada
    var edadProfesor =31
    var hola= "hola"
    var edadCachorro:Int
    edadCachorro = 3
    //las edad mutables puede ser cambiadas
    edadProfesor = 33
    edadCachorro = 4

    //INMUTABLES, val no se pueden reasignar

    val numeroCuenta = 123456
//    numeroCuenta = 12

    // Tipos variables

    val nombreProfesor = "Vicente A"
    val sueldo = 12.20
    val apellidoProfesor = "Eguez"
    val fechaNacimiento = Date() //new date()

    if(sueldo ==12.20){

    } else {

    }

    //when es muestro swith en kotlin
    when(sueldo){
        12.20 -> println("SUELDO NORMAL")
        -12.20 -> println("SUELDO NEGATIVO")
        else -> println("no se reconoce el sueldo ")
    }
    //no se debe escribir código inecesario.

    val esSueldoMayorAlEstablecido = if(sueldo == 12.20) true else false
    //Expresion ? x:y

    calcularSueldo(10000.00, 14.00)
    calcularSueldo(
            tasa=16.00,
            sueldo = 800.00,
            calculoEspecial = 12)

    val arregloConstante: Array<Int> = arrayOf(1,2,3) //arreglos contantes, no se pueden anadir elementos
    val arregloCupleanos: ArrayList<Int> = arrayListOf(30, 31, 22, 23, 20) // puedo anadir o eliminar elmentos

    print(arregloCupleanos)
    arregloCupleanos.add(24)
    print(arregloCupleanos)
    arregloCupleanos.remove(30)
    print(arregloCupleanos)

    arregloCupleanos
            .forEach {
                println("Valor de la iteracion " + it)
            }
    arregloCupleanos
            .forEach { valorIteracion: Int ->
                println("Valor de la iteracion " + valorIteracion)
            }
    arregloCupleanos
            .forEach (
                { valorIteracion: Int ->
                    println("Valor de la iteracion " + valorIteracion)
                }
            )

    arregloConstante
            .forEachIndexed { index: Int, it: Int ->
                println("Valor de la iteracion " + it)


            }

    val respuestaForeach = arregloCupleanos
            .forEach { valorIteracion: Int ->
                println("Valor de la iteracion " + valorIteracion)
            }

    println(respuestaForeach) // devuelve Unit

    // operadores están en todos los lenguajes, nos ayudan a resolver cualquier problema
    // foreach no devuelve nada, es decir devuelve UNIT.

    //queremos cambiar a todo el arreglo a negativo
    arregloCupleanos
            .forEach { valorIteracion: Int ->
                println("Valor iteracion "+ valorIteracion)
                println("Valor con -1 ${valorIteracion}*-1")
            }

//si deseamos cambiar los valores de los elementos no sirve forEach

    //MAP -> MUTA EL ARREGLO O CAMBIA EL ARREGLO
    //Enviemso el nuevo valor de la iteeracion
    //nos devuelve un nuevo arreglo
    val respuestaMap = arregloCupleanos
            .map { iteracion: Int ->
               iteracion * -1
            }

    //peudo tranformar en un nuevo arreglo que yo necesite
    val respuestaMapDos = arregloCupleanos
            .map { iteracion: Int ->
                val nuevoValor = iteracion * -1
                val otroValor = nuevoValor * 2
                return@map otroValor
            }
    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCupleanos)

    //quiero que solo me devuelva los valores mayores a 23

    //FILTER

    //VAMOS A FILTRAR EL ARREGLO
    //Nos crea un nuevo arreglo, en programacion funcional no modifa original
    // aqui devolvemos una expresion, es decir devolvemos verdadero o falso
    //devuleve un arrelo que cumple la expresion

    val respuestaFilter = arregloCupleanos
            .filter {iteracion: Int ->
                val mayor23 = iteracion > 23
                return@filter mayor23
            }

    arregloCupleanos
            .filter{
                iteracion:Int -> iteracion > 23
            }
    println(respuestaFilter)
}//parámetros nombrados, en el orden que deseamos
fun calcularSueldo(
        sueldo: Double, //requeridos
        tasa: Double = 12.00, // por defecto
        calculoEspecial:Int? = null//Opcional o pueden ser nulos
): Double {
    if (calculoEspecial !=null ){
        return sueldo * tasa * calculoEspecial
    }else{
        return sueldo * tasa
    }

}
fun imprimirMensaje():Unit{ //Unit = Void, también no se debe especificar nada
    println("")
}


//como incializar variable




