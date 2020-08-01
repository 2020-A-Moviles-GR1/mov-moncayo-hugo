
fun main(args:Array<String>) {

    val entrenadores = ArrayList<Empresas>()
    val pokemones = ArrayList<Empleado>()


}
class Empresas(
    var nombreEmpresa:String,
    var direccionEmpresa:String,
    var telefonEmpresa:Int,
    var estadoEmpresa:Boolean,
    var capitalEmpresa:Float
){
    override fun toString(): String {
        return "Empresa(Empresa='$nombreEmpresa', " +
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
        return "Pokemon(Empleado='$nombresEmpleado', " +
                "Salario=$salarioEmpleado, " +
                "edadEmpleado=$edadEmpleado, " +
                "Estado Empleado=$estadoEmpleado, " +
                "Departamento='$departamentoEmpleado')"
    }
}