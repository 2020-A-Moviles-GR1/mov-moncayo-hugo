import  java.util. *
import  java.util.function.Consumer

fun  main ( args :  Array < String > ) {
    imprimir ( " Hola " )
    // Ejemplo java:
    // Int edad = 31;
    // mutables
    var edadProfesor =  31    // No especificamos el tipo de dato
    // ; No es necesario
    // Pato escribiendo
    // var edadCachorro; X -> necesitamos el tipo de datos
    var edadCachorro :  Int
    edadCachorro =  3
    edadProfesor =  32
    edadCachorro =  4
    // Inmutables
    val numeroCuenta =  123456  // NO SE PUEDEN REASIGNAR
    // numeroCuenta = 123

    // Variables de tipos
    val nombreProfesor :  String  =  " Vicente Adrian "
    val sueldo :  Doble  =  12.20
    val apellidosProfesor :  Char  = 'a'
    val fechaNacimiento =  Date () // new Date ()

    if (sueldo ==  12.20 ) {

    } más {

    }

    cuando (sueldo) {
        12.20  - >  println ( " Sueldo normal " )
        - 12.20  - >  println ( " Sueldo negativo " )
        de lo contrario  - >  println ( " No se reconoce el sueldo " )
    }

    val esSueldoMayorAlEstablecido =  if (sueldo ==  12.20 ) verdadero  más  falso
    // EXPRESION? X: Y
    // calcularSueldo (1000.00, 14.00)
    calcularSueldo ( 1000.00 , 14.00 )
    calcularSueldo (
            tasa =  16.00 ,
            sueldo =  800.00
    ) // Parámetros con nombre
    calcularSueldo ( 700.00 )
    calcularSueldo (sueldo =  650.00 )

    val arregloConstante :  Array < Int >  = arrayOf ( 1 , 2 , 3 )
    val arregloCumpleanos :  ArrayList < Int >  = arrayListOf ( 30 , 31 , 22 , 23 , 20 )
    imprimir (arregloCumpleanos)
    arregloCumpleanos.add ( 24 )
    imprimir (arregloCumpleanos)
    // arregloCumpleanos.remove (30)
    arregloCumpleanos.remove ( 30 )
    imprimir (arregloCumpleanos)


    arregloCumpleanos
            .forEach {valorIteracion :  Int  - >
                println ( " Valor iteracion: "  + valorIteracion)
            }
    arregloCumpleanos
            .para cada(
            {valorIteracion :  Int  - >
                println ( " Valor iteracion: "  + valorIteracion)
            }
            )

    // Operadores -> TODOS LOS LENGUAJES
    // ForEach no devuelve nada -> Unidad
    arregloCumpleanos
            .forEach {iteracion :  Int  - >
                println ( " Valor de la iteracion "  + iteracion)
                println ( " Valor con -1 = $ {iteracion *  - 1 }  " )
            }

    val respuestaArregloForEach = arregloCumpleanos
            .forEachIndexed {index :  Int , iteracion :  Int  - >
                println ( " Valor de la iteracion "  + iteracion)
            }
    println (respuestaArregloForEach) // Unidad vacía

    // MAPA -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteración
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados
    val respuestaMap = arregloCumpleanos
            .map {iterador :  Int  - >
                iterador *  - 1
            }
    val respuestaMapDos = arregloCumpleanos
            .map {iterador :  Int  - >
                val nuevoValor = iterador *  - 1
                val otroValor = nuevoValor *  2
                return @map  Date ()
            }
    println (respuestaMap)
    println (respuestaMapDos)
    println (arregloCumpleanos)

    // Filtro -> FILTRAR EL ARREGLO
    // 1) Devolver una expresión (VERDADERO o FALSO)
    // 2) Nuevo arreglo que cumpla esa expresion
    val respuestaFilter = arregloCumpleanos
            .filter {iteracion :  Int  - >
                val esMayorA23 = iteracion >  23
                volver @filter esMayorA23
            }
    arregloCumpleanos.filter {it >  23 }
    println (respuestaFilter)
    println (arregloCumpleanos)

    // Cualquiera -> O (Algunos)
    // Todos -> Y (Todos)
    // Y -> VERDADERO, Todo lo demas falso
    // O -> TODO es falso, lo demas era verdadero
    // 1) Devolver una expresión (VERDADERO o FALSO)
    // 2) Devuelve un Booleano
    // (30, 31, 22, 23, 20)
    val respuestaAny = arregloCumpleanos
            .any {iterador :  Int  - >
                return @ cualquier iterador <  25
            }
    println (respuestaAny)

    val respuestaAll = arregloCumpleanos
            .all {iterador :  Int  - >
                return @todos iterador >  18
            }
    println (respuestaAll)


    // Reducir
    // 1) Devuelve el acumulado
    // 2) En que valor comienza
    // Devuelve un numero
    // (30, 31, 22, 23, 20)
    // ("a", "b", "c", "d")
    // "abcd"
    val respuestaReduce = arregloCumpleanos // Acumulador 0
            .reduce ({acumulador, iteracion - >
                return @reduce acumulador + iteracion
            })
    println (respuestaReduce)

    val respuestaFold = arregloCumpleanos
            .doblez(
                    100 ,
                    {acumulador, iteracion - >
                        return @fold acumulador - iteracion
                    }
            )
    // arregloCumpleanos.reduceRigth
    // arregloCumpleanos.foldRight
    println (respuestaFold)
    // forEach -> nada
    // mapa -> Arreglo
    // filtro -> Arreglo
    // todos -> Booleano
    // cualquiera -> Booleano
    // reducir -> Valor
    // doblar -> Valor

    // Reducir el daño en 20%
    // 18 <
    // (30, 31, 22, 23, 20)
    val vidaActual = arregloCumpleanos
            .map {it *  0.8 } // (24, 24.8, 17.7, 18.4, 16)
            .filter {it >  18 } // (24, 24.8, 18.4)
            .fold ( 100.00 , {acc, d - > acc - d})
            . también { println (it)}

}

divertido  calcularSueldo (
sueldo :  Doble , // Requeridos!
tasa :  Doble  =  12.00 , // Tiene valor defecto
calculoEspecial :  Int?  =  nulo  // Pueden ser nulos
) :  Doble {
    if (calculoEspecial ! =  null ) {
        volver sueldo * tasa * calculoEspecial
    } más {
        volver sueldo * tasa
    }
}


divertido  imprimirMensaje () { // Unit = Void
    println ( " " )
}


// Clases Abstractas

clase  abstracta NumerosJava {   // val nuevosNumeros = Numeros (1,2)
    protegido  val numeroUno :  Int
    privado  val numeroDos :  Int

    constructor ( uno :  Int , dos :  Int ) {
        numeroUno = uno
        numeroDos = dos
    }
}

clase  abstracta Numeros ( // val nuevosNumeros = Numeros (1,2)
val  numeroUno protegido :  Int ,
protegido  val  numeroDos :  Int
) {
}

clase  Suma (
uno :  Int , // Parámetro
dos :  Int  // Parametro
) :  Numeros (uno, dos) {
    fun  sumar () : Int {
        // this.uno o this.dos NO ESTAN DISPONIBLES
        devuelve  este .numeroUno +  este .numeroDos
    }
}

clase  SumaDos (
public  var  uno :  Int , // Propiedades
public  var  dos :  Int  // Propiedades
) :  Numeros (uno, dos) {
    fun  sumar () : Int {
        este .uno
        esto .dos
        devuelve  este .numeroUno +  este .numeroDos
    }
}


