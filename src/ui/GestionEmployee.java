package ui;
import dol.Employee;
import Utility.Archivos;
import dol.TrabajosHoras;
import dol.TrabajoBeneficio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import ui.Validacion;

public class GestionEmployee {
	
	private static NominaEmployee nomina;
	private static Scanner scan;
	private static Archivos archivo;

	public GestionEmployee(Scanner scan) {
		nomina = new NominaEmployee();
		this.scan= scan;
		archivo = new Archivos();
	}
	
	public static Employee DatosdelEmpleado() {
		
		Employee empleado= new Employee();
		empleado.setFirstName1(Validacion.ValidateString("\nIngresar nombre 1 > ", "error", scan));
		empleado.setSecondName2(Validacion.ValidateString("Ingresar nombre 2 > ", "error", scan));
		empleado.setLastname1(Validacion.ValidateString("Ingresar Apellido 1 > ", "error", scan));
		empleado.setLastname2(Validacion.ValidateString("Ingresar Apellido > ", "error", scan));
		empleado.setActivo(true);
		
		TrabajosHoras horas = new TrabajosHoras();
		horas.setHoras(Validacion.ValidateDouble("Ingresar horas > ","error", scan));
		horas.setHorasExtras(Validacion.ValidateDouble("Ingresar horas extras > ","error", scan));
		
		TrabajoBeneficio beneficios = new TrabajoBeneficio();
		beneficios.setComisiones(Validacion.ValidateDouble("Ingresar comisiones > ","error", scan));
		beneficios.setBonificaciones(Validacion.ValidateDouble("Ingresar bonificacion > ","error", scan));
		
		empleado.setHoras(horas);
		empleado.setBeneficios(beneficios);
		return empleado;
	}
	
	/*public static void PrintNominaEmployee() {
		
			System.out.println("=============================================================");
			System.out.println(e.getFirstName1()+" "+ e.getSecondName2()+" "+nomina.SalarioMensual());
			System.out.println(" >Horas Extras: "+nomina.GetHorasExtras()+" >Monto Horas Extras: "+nomina.CalculoHorasExtras());
			System.out.println(" >Comisiones: "+nomina.GetComisiones()+"   >Bonificaciones: "+nomina.GetBonificaciones());
			System.out.println(" >Total Ingresos: "+nomina.CalculoTotalIngresos());
			System.out.println(" >INSS Laboral: "+nomina.CalculoINSSMensual()+" >IR Laboral: "+nomina.CalcularIRPatronalMensual());
			System.out.println("=============================================================");
			System.out.println("\n");

	}*/
	
	public static void PrintEmpleado(Employee empleado) {
		System.out.println("id: "+empleado.getId());
		System.out.println("Nombre: "+empleado.getFirstName1());
		System.out.println("2do nombre: "+empleado.getLastname1());
	}
	
}
