
fun main(args:Array<String>) {

    val empresas = ArrayList<Empresas>()
    val empleados = ArrayList<Empleado>()
    //println("prueba de correr main
    // como clase luego de configuracion")
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
    var departamentoEmpleado:String
){
    override fun toString(): String {
        return "Empleado (Nombre Empleado='$nombresEmpleado', " +
                "Salario=$salarioEmpleado, " +
                "edadEmpleado=$edadEmpleado, " +
                "Estado Empleado=$estadoEmpleado, " +
                "Departamento='$departamentoEmpleado')"
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
    texto += "-       MENÚ EMPRESAS       -" + "\n"
    texto += "- 1. Ingresar Empresa (C)    -" + "\n"
    texto += "- 2. Mostrar Empresa (R) -" + "\n"
    texto += "- 3. Modificar Empresa (U)          -" + "\n"
    texto += "- 4. Eliminar Empresa  (D)         -" + "\n"
    texto += "- 5. Regresar         -" + "\n"
    texto += "********************************************" + "\n"
    println(texto)
    var opcion: Int
    while (true) {
        try {
            opcion = readLine().toString().toInt()
            if (opcion > 5 || opcion < 1) {
                print("ingrese un valor correcto")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            print("Ingrese un valor valido")
        }
    }
    when (opcion) {
        1 -> crearEmpresa(empresas)
        2 -> mostrarEmpresa()
        3 -> modificarEmpresa()
        4 -> eliminarEmpresa()
        5 -> estado = false
    }
    return estado
}

fun crearEmpresa(empresas : ArrayList<Empresas>){
    print("Ingrese nombre de la Empresa: ")
    val nombre = readLine().toString()
    print("Ingrese Dirección de la Empresa: ")
    val direccion = readLine().toString()
    print("Ingrese teléfono de la Empresa: ")
    val telefono = readLine().toString().toInt()
    print("La Empresa está activa? (true o false) ")
    val estado = readLine()!!.toBoolean()
    print("Ingrese el Capital de la Empresa: ")
    val capital = readLine().toString().toFloat()
    empresas.add( Empresas(nombre,direccion,telefono,estado,capital))
}
fun mostrarEmpresa(){

}
fun modificarEmpresa(){

}
fun eliminarEmpresa (){

}