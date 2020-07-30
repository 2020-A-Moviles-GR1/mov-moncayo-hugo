package Main;

public class kt {
    public static void main(String[] args) throws IOException {
		/* int opciones, op;
		    int i=0;
		    String[] escoger ={"Empl.Asalariado", "Empl.Por Comision", "Empl.Por Horas","Empl.Base Mas Comision"};

		//Empleado [] empleados = new Empleado[5];
		    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		//for (int i=0;i<5;i++)
		    do{
			 opciones = JOptionPane.showOptionDialog(null, "Elija Una Opcion", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escoger, 0);
		switch(opciones){
		case 0:
			//empleados[i]= new EmpleadoAsalariado();
			empleados.add(new EmpleadoAsalariado());
			break;
		case 1:
			//empleados[i]= new EmpleadoPorComision();
			empleados.add(new EmpleadoPorComision());
			break;
		case 2:
			//empleados[i]= new EmpleadoPorHoras();
			empleados.add(new EmpleadoPorHora());
			break;
		case 3:
			//empleados[i]= new EmpleadoBaseMasComision();
			empleados.add(new BaseMasComision());
			break;
		}

		//empleados.get(i++).setEmpleado();
		op= JOptionPane.showConfirmDialog(null, "Continua.....?","Mas Empleados", JOptionPane.YES_NO_CANCEL_OPTION);
		//empleados[i].setEmpleado();

		}while(op==JOptionPane.YES_OPTION);
		String salida="";
		for (Empleado emp: empleados){
 	  salida+=emp.toString()+"\n Salario= "+emp.getSalario()+"\n";
 	  JOptionPane.showMessageDialog(null, salida);
   }

	*/
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        File fe = new File("datos.txt");
        File fs = new File("Resultado.txt");
        BufferedReader entrada = new BufferedReader(new FileReader(fe));
        BufferedWriter salida = new BufferedWriter(new FileWriter(fs));

        String linea="";
        try{
            while(entrada.ready()){
                linea = entrada.readLine();
                StringTokenizer tokens = new StringTokenizer(linea,"/");
                String codigo = tokens.nextToken();
                String datoemp = tokens.nextToken();
                String dato = tokens.nextToken();
                StringTokenizer tokens1 = new StringTokenizer(dato,",");
                if(codigo.compareTo("ES")==0){
                    empleados.add(new EmpleadoAsalariado());
                    EmpleadoAsalariado emp = new EmpleadoAsalariado();
                    emp.setNombres(datoemp);
                    emp.setSalarioSemanal(Double.parseDouble(dato));
                    salida.write( "El nombre del emplado es: "+emp.getNombres()+" Su salario sera: "+ emp.getSalario()+" /Empleado Asalariado");
                    salida.newLine();
                }
                if(codigo.compareTo("EC")==0) {
                    empleados.add(new EmpleadoPorComision());
                    EmpleadoPorComision emp = new EmpleadoPorComision();
                    emp.setNombres(datoemp);
                    String tazaComicion = tokens1.nextToken();
                    String ventasBrutas = tokens1.nextToken();
                    emp.setTazaComision(Double.parseDouble(tazaComicion));
                    emp.setVentasBrutas(Double.parseDouble(ventasBrutas));
                    salida.write("El nombre del emplado es: "+emp.getNombres()+" Su salario sera: "+ emp.getSalario()+" /Empleado por Comision");
                    salida.newLine();
                }
                if(codigo.compareTo("EH")==0) {
                    empleados.add(new EmpleadoPorHora());
                    EmpleadoPorHora emp = new EmpleadoPorHora();
                    String horas = tokens1.nextToken();
                    String costoHora = tokens1.nextToken();
                    emp.setNombres(datoemp);
                    emp.setNumHorasTrabajadas(Double.parseDouble(horas));
                    emp.setCostoHora(Double.parseDouble(costoHora));
                    salida.write("El nombre del emplado es: "+emp.getNombres()+" Su salario sera: "+ emp.getSalario()+" /Empleado por Horas");
                    salida.newLine();
                }
                if(codigo.compareTo("EBC")==0) {
                    empleados.add(new BaseMasComision());
                    BaseMasComision emp = new BaseMasComision();
                    String tazaComicion = tokens1.nextToken();
                    String ventasBrutas = tokens1.nextToken();
                    String base = tokens1.nextToken();
                    emp.setNombres(datoemp);
                    emp.setTazaComision(Double.parseDouble(tazaComicion));
                    emp.setVentasBrutas(Double.parseDouble(ventasBrutas));
                    emp.setSueldoBase(Double.parseDouble(base));
                    salida.write("El nombre del emplado es: "+emp.getNombres()+" Su salario sera: "+ emp.getSalario()+" /Empleado sueldo base mas comision");
                    salida.newLine();
                }


            }
        }catch(IOError e){
            e.printStackTrace();

        }
        entrada.close();
        salida.close();
    }
}
