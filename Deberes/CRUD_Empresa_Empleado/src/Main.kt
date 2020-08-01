import java.io.File
import kotlin.collections.ArrayList

fun main(args:Array<String>) {

    val empresas = ArrayList<Empresas>()
    val empleados = ArrayList<Empleado>()
    leerEmpresas(empresas)
    leerEmpleados(empleados)
    while (true)
    menu(empresas,empleados)

}
class Empresas(
    var nombreEmpresa:String,
    var direccionEmpresa:String,
    var telefonEmpresa:Int,
    var estadoEmpresa:Boolean,
    var capitalEmpresa:Float
){
    override fun toString(): String {
        return "Empresa(Nombre Empresa='$nombreEmpresa', " +
                "Direccion='$direccionEmpresa', " +
                "Telefono Empresa='$telefonEmpresa', " +
                "Estado Empresa=$estadoEmpresa, " +
                "CapitalEmpresa=$capitalEmpresa.)"
    }
}
class Empleado(
    var nombresEmpleado:String,
    var salarioEmpleado:Float,
    var edadEmpleado: Int,
    var estadoEmpleado:Boolean,
    var EmpresaEmpleado: String
){
    override fun toString(): String {
        return "Empleado (Nombre Empleado='$nombresEmpleado', " +
                "Salario=$salarioEmpleado, " +
                "edadEmpleado=$edadEmpleado, " +
                "Estado Empleado=$estadoEmpleado, " +
                "Departamento='$EmpresaEmpleado')"
    }
}

fun leerEmpresas(empresas: ArrayList<Empresas>) {
    File("Empresas.txt")
        .forEachLine {
            var a = it.split("|")
            empresas.add(Empresas(a[0],a[1],a[2].toInt(),a[3].toBoolean(),a[4].toFloat()))
        }
}

fun leerEmpleados(empleados: ArrayList<Empleado>) {
    File("Empleados.txt")
        .forEachLine{
            var a = it.split("|")
            empleados.add(Empleado(a[0],a[1].toFloat(),a[2].toInt(),a[3].toBoolean(),a[4]))
        }
}

//Menús
fun menu(empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>) {
    var texto: String
    texto = "********************************************" + "\n"
    texto += "-          Menú Principal            " + "\n"
    texto += "1. Menú Empresa        " + "\n"
    texto += "2. Menú Empleados  " + "\n"
    texto += "3. Salir                           " + "\n"
    texto += "********************************************" + "\n"
    println(texto)

    var numeroMenu: Int
    while (true) {
        try {
            numeroMenu = readLine().toString().toInt()
            if (numeroMenu > 6 || numeroMenu < 1) {
                print("Ingrese un número entre 1 a 6 ")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            print("Ingrese un número ")
        }
    }

    when (numeroMenu) {
        1 ->
            {
                while (menuEmpresa(empresas, empleados)) {
                }
            }
        2 ->
            {
                while (menuEmpleado(empresas, empleados)) {
                }
            }
        3 -> System.exit(0)
    }


}

fun menuEmpresa(empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>): Boolean {
    var estado = true
    var texto: String
    texto = "********************************************" + "\n"
    texto += "-       MENÚ EMPRESAS        -" + "\n"
    texto += "- 1. Ingresar Empresa (C)    -" + "\n"
    texto += "- 2. Mostrar Empresa (R)     -" + "\n"
    texto += "- 3. Modificar Empresa (U)   -" + "\n"
    texto += "- 4. Eliminar Empresa  (D)   -" + "\n"
    texto += "- 5. Regresar                -" + "\n"
    texto += "********************************************" + "\n"
    println(texto)
    var opcion: Int
    while (true) {
        try {
            opcion = readLine().toString().toInt()
            if (opcion > 5 || opcion < 1) {
                print("ingrese un valor entre 1 a 5")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            print("Ingrese un valor entero ")
        }
    }
    when (opcion) {
        1 -> crearEmpresa(empresas)
        2 -> mostrarEmpresa(empresas)
        3 -> modificarEmpresa(empresas)
        4 -> eliminarEmpresa(empresas, empleados)
        5 -> estado = false
    }
    return estado
}

fun crearEmpresa(empresas : ArrayList<Empresas>){
    print("Ingrese nombre de la Empresa: ")
    val nombre = readLine().toString()
    print("Ingrese dirección de la Empresa: ")
    val direccion = readLine().toString()
    print("Ingrese teléfono de la Empresa: ")
    val telefono = readLine().toString().toInt()
    print("La Empresa está activa? (true o false) ")
    val estado = readLine()!!.toBoolean()
    print("Ingrese el Capital de la Empresa: ")
    val capital = readLine().toString().toFloat()
    empresas.add( Empresas(nombre,direccion,telefono,estado,capital))
    guadarEmpresaArchivo(empresas)
}
fun guadarEmpresaArchivo(empresas: ArrayList<Empresas>){
    var texto:String=""

    empresas
        .forEach {
        texto += it.nombreEmpresa+"|" +
                ""+it.direccionEmpresa+"|" +
                ""+it.telefonEmpresa+"|" +
                ""+it.estadoEmpresa+"|" +
                ""+it.capitalEmpresa+"|" +
                ""+"\n"
    }

    File("Empresas.txt").appendText(texto)
}
fun mostrarEmpresa(empresas: ArrayList<Empresas>){
    empresas
        .forEach {
            println("-" + it)
        }
}
fun modificarEmpresa(empresas: ArrayList<Empresas>){
    print("¿Qué empresa desea modificar?: ")
    val nombre = readLine().toString()
    val empresaExiste = empresas
        .removeIf {
            iteracion : Empresas ->
            iteracion.nombreEmpresa==nombre
        }
    if(empresaExiste){
        print("Ingrese nueva dirección: ")
        val nuevaDireccion = readLine().toString()
        print("Ingrese nuevo teléfono: ")
        val nuevoTelefono = readLine().toString().toInt()
        print("¿La empresa continúa activa? true o false ")
        val nuevoEstado = readLine()!!.toBoolean()
        print("Ingrese el nuevo capital de la empresa:  ")
        val nuevoCapital = readLine().toString().toFloat()
        empresas.add( Empresas(nombre,nuevaDireccion,nuevoTelefono,nuevoEstado,nuevoCapital))
    }else{
        println("No existe esta Empresa")
    }
}
fun eliminarEmpresa (empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>){
    print("¿Qué empresa desea eliminar?: ")
    var nombreEmpresaEliminar = readLine().toString()
    var existeEmpresa = empresas.removeIf { iteracion : Empresas ->
        iteracion.nombreEmpresa==nombreEmpresaEliminar
    }
    if(existeEmpresa){
        eliminarEmpresaConEmpleados(nombreEmpresaEliminar, empleados)
    }else{
        print("No existe esta Empresa")
    }

}

fun menuEmpleado(empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>): Boolean {
    var estado = true
    var texto: String
    texto = "********************************************" + "\n"
    texto += "-       MENÚ EMPLEADO       -" + "\n"
    texto += "- 1. Ingresar Empleado (C)  -" + "\n"
    texto += "- 2. Mostrar Empleado (R)   -" + "\n"
    texto += "- 3. Modificar Empleado (U) -" + "\n"
    texto += "- 4. Eliminar Empleado (D)  -" + "\n"
    texto += "- 5. Regresar               -" + "\n"
    texto += "********************************************" + "\n"
    println(texto)
    var opcion: Int
    while (true) {
        try {
            opcion = readLine().toString().toInt()
            if (opcion > 5 || opcion < 1) {
                print("Ingrese un valor enre 1 a 5")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            print("Ingrese un valor valor entero")
        }
    }
    when (opcion) {
        1 -> crearEmpleado(empresas, empleados)
        2 -> mostrarEmpleado(empleados)
        3 -> modificarEmpleado(empresas, empleados)
        4 -> eliminarEmpleado(empleados)
        5 -> estado = false
    }
    return estado
}
fun crearEmpleado(empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>){
    print("Ingrese el nombre de la Empresa que pertece el Empleado: ")
    var nombreEmpresa = readLine().toString()
    var empresa = empresas
        .find { it: Empresas ->
            it.nombreEmpresa == nombreEmpresa
        }
    if (empresa != null) {

    print("Ingrese nombre del Empleado: ")
    val nombre = readLine().toString()
    print("Ingrese el Salario del Empleado: ")
    val salario = readLine().toString().toFloat()
    print("Ingrese Edad del Empleado: ")
    val edad = readLine().toString().toInt()
    print("El empleado está en nomina (true o false)? ")
    val estado = readLine()!!.toBoolean()
    print("Ingrese Departamento del Empleado: ")
    val departamento = readLine().toString()
    empleados.add( Empleado(nombre,salario,edad,estado,nombreEmpresa))
    guadarEmpleadoArchivo(empleados)
    }
    else
    {
        println("No existe este entrenador")
    }

}
fun guadarEmpleadoArchivo(empleados: ArrayList<Empleado>){
    var texto:String=""
    empleados
        .forEach {
                texto += it.nombresEmpleado+"|" +
                ""+it.salarioEmpleado+"|" +
                ""+it.edadEmpleado+"|" +
                ""+it.estadoEmpleado+"|" +
                ""+it.EmpresaEmpleado+"|" +
                ""+"\n"
        }
        File("Empleados.txt").appendText(texto)
}
fun mostrarEmpleado(empleados: ArrayList<Empleado>){
    empleados
        .forEach {
            println("-" + it)
        }
}
fun modificarEmpleado(empresas: ArrayList<Empresas>, empleados: ArrayList<Empleado>){
    println("Ingrese el nombre del empleado a actualizar: ")
    var nombre = readLine().toString()
    var nombreEmpleado = empleados.removeIf { iteracion: Empleado ->
        iteracion.nombresEmpleado == nombre
    }
    if (nombreEmpleado) {
        crearEmpleado(empresas, empleados)
    } else {
        println ("El empleado no existe")
    }

}
fun eliminarEmpleado (empleados: ArrayList<Empleado>){
    print("Ingrese el nombre del Empleado a eliminar: ")
    val empleadoEliminar = readLine().toString()
    val existeEmpleado = empleados
        .removeIf {
                iteracion: Empleado ->
                iteracion.nombresEmpleado == empleadoEliminar
        }
    if (!existeEmpleado)
        println("No existe el Empleado")

}

fun eliminarEmpresaConEmpleados(empresa: String, empleados: ArrayList<Empleado>) {
    empleados.removeIf { iteracion: Empleado ->
        iteracion.EmpresaEmpleado == empresa
    }
}