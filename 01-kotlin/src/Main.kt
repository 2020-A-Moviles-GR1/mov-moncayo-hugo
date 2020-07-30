import java.util.*

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



