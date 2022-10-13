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
	
	private static Scanner scan;
	
	public GestionEmployee(Scanner scan) {
		this.scan= scan;
	}
	
	public static Employee DatosdelEmpleado() {
		
		Employee empleado= new Employee();
		empleado.setFirstName1(Validacion.ValidateString("\nIngresar nombre 1 > ", "error", scan));
		empleado.setSecondName2(Validacion.ValidateString("Ingresar nombre 2 > ", "error", scan));
		empleado.setLastname1(Validacion.ValidateString("Ingresar Apellido 1 > ", "error", scan));
		empleado.setLastname2(Validacion.ValidateString("Ingresar Apellido > ", "error", scan));
		empleado.setSalarioMensualBruto(Validacion.ValidateDouble("Ingresar Salario > ", "error", scan));
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
	
	public static void PrintEmpleado(Employee empleado) {
		System.out.println("");
		System.out.println("id: "+empleado.getId());
		System.out.println("Nombre: "+empleado.getFirstName1());
		System.out.println("2do Nombre: "+empleado.getSecondName2());
		System.out.println("1er Apellido: "+empleado.getLastname1());
		System.out.println("2do Apellido: "+empleado.getLastname2());
		System.out.println("Horas: "+empleado.getHoras().getHoras());
		System.out.println("Horas extras: "+empleado.getHoras().getHorasExtras());
		System.out.println("Comisiones: "+empleado.getBeneficios().getComisiones());
		System.out.println("beneficios: "+empleado.getBeneficios().getBonificaciones());
	}
	
	public static void PrintEmpleadoNomina(Employee empleado) {
		
		NominaEmployee nominaEmploye = new NominaEmployee();
		nominaEmploye.SetEmployee(empleado);
		System.out.println(" ");
		System.out.println("Nombre Completo: "+empleado.getFirstName1()+" "+empleado.getLastname1());
        System.out.println("Salario Mensual: "+nominaEmploye.SalarioMensual());
		System.out.println("Horas: "+empleado.getHoras().getHoras()+" Horas Extras "+empleado.getHoras().getHorasExtras()+" Monto: "+nominaEmploye.CalculoHorasExtras());
		System.out.println("Comisiones: "+empleado.getBeneficios().getComisiones()+" "+empleado.getBeneficios().getBonificaciones()+" Monto: "+nominaEmploye.CalculoTotalBeneficios());
		System.out.println("TotalIngresos: "+nominaEmploye.CalculoTotalIngresos());
		System.out.println("INSS LABORAL:"+nominaEmploye.CalculoINSSMensual());
		System.out.println("Salario Total: "+nominaEmploye.SalarioTotal());
	}
	
	
	
}
