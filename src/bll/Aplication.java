package bll;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import dall.EmployeeDall;
import Utility.Archivos;
import dol.Employee;
import ui.GestionEmployee;
import ui.Validacion;

public class Aplication {
	
	public static void MenuEmpleado() {
		EmployeeDall archivo = new EmployeeDall();
		Scanner scan = new Scanner(System.in);
		GestionEmployee gestion = new GestionEmployee(scan);
		
		int Opcion = 0;
		
		do {
			System.out.print("\n1: Gestion del empleado");
			System.out.print("\n2: Nomina del empleado");
			System.out.print("\n3: Salir");
			Opcion= Validacion.ValidateInt("\nIngresar Opcion: ", "\nNumero no valido\n", scan, 1, 3);
			
			switch(Opcion) {
			case 1:
				do {
					Opcion = 0;
					System.out.print("\nGestion del empleado");
					System.out.print("\n1: Agregar empleado");
					System.out.print("\n2: Modificar empleado");
					System.out.print("\n3: Eliminar empleado");
					System.out.print("\n4: Listar empleado");
					System.out.print("\n5: Volver al menu principal");
					Opcion= Validacion.ValidateInt("\nIngresar Opcion: ", "\nNumero no valido\n", scan, 1, 5);
					switch(Opcion) {
					case 1: 
						System.out.println("=================================================");
						System.out.println("\n1: Agregar empleado");
                        
                        try {
                        	Archivos.CrearFileUser(new File("Employee.txt"));
                        	Archivos.CrearEmployee(gestion.DatosdelEmpleado());
                        	Archivos.Cerrar();
						} catch (Exception e) {
							
						}
						System.out.println("Empleado Guardado");
						System.out.println("=================================================");
						break;
					case 2:
						System.out.println("=================================================");
						System.out.println("\n2: Modificar empleado");
						System.out.println("=================================================");
						break;
					case 3:
						System.out.println("=================================================");
						System.out.println("\n3: Eliminar empleado");
						System.out.println("=================================================");
						break;
					case 4:
						System.out.println("\n4: Listar empleado");
						try {
							Archivos.CrearFileUser(new File("Employee.txt"));
				             int i = Archivos.buscarRegistro();
			
				            for (i = 0; i < Archivos.getNumerodeRegistro(); i++) {
				            	Employee e= Archivos.getUser(i);
				                if(e.isActivo()){
				                    GestionEmployee.PrintEmpleado(e);
				                }else {
				                	System.out.println("El id no existe");
				                }
				                
				            }
				            
				            
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						break;
					}	
		
				}while(Opcion!= 5);	
				
				break;
				
			case 2:
				System.out.println("\nNomina del empleado");
				
				break;
			}
			
			
		}while(Opcion!= 3);
	}

}
