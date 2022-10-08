package Utility;

import dol.Employee;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import dol.TrabajosHoras;
import dol.TrabajoBeneficio;

public class Archivos {

	private static RandomAccessFile flujo;
	private static int NumerodeRegistro;
	private static int TamanoRegistro = 100;// cada empleado tendra una asignacion de 100 bytes

	public static void CrearFileUser(File archivo) throws IOException {
		// Validacion del archivo, ruta, directorio y extencion.
		if (archivo.exists() && !archivo.isFile()) {
			System.out.println("El archivo no existe");
		}
		flujo = new RandomAccessFile(archivo, "rw");
		// La clase Math.Ceil sube el entero aproximado superior del tamaño del flujo.
		NumerodeRegistro = (int) Math.ceil((double) flujo.length() / (double) TamanoRegistro);
	}

	public static void Cerrar() throws IOException {
		flujo.close();
	}
	
	public static int getNumerodeRegistro() {
		return NumerodeRegistro;
	}

	public static boolean Setempleado(int i, Employee empleado) throws IOException {

		if (i >= 0 && i <= getNumerodeRegistro()) {

			flujo.seek(i * TamanoRegistro);
			flujo.writeUTF(empleado.getId().toString());
			flujo.writeUTF(empleado.getFirstName1());
			flujo.writeUTF(empleado.getSecondName2());
			flujo.writeUTF(empleado.getLastname1());
			flujo.writeUTF(empleado.getLastname2());
			flujo.writeBoolean(empleado.isActivo());
			flujo.writeUTF(String.valueOf(empleado.getHoras().getHoras()));
			flujo.writeUTF(String.valueOf(empleado.getHoras().getHorasExtras()));
			flujo.writeUTF(String.valueOf(empleado.getBeneficios().getBonificaciones()));
			flujo.writeUTF(String.valueOf(empleado.getBeneficios().getComisiones()));
		
			return true;
		} else {
		}

		return false;
	}
	
	public static int buscarRegistroInactivo() throws IOException {
        String nombre;
        for (int i = 0; i < getNumerodeRegistro(); i++) {
            flujo.seek(i * TamanoRegistro);
            if (!getUser(i).isActivo()) {
                return i;
            }
        }
        return -1;
    }

	public static void CrearEmployee(Employee empleado) throws IOException {
		int inactivo= buscarRegistroInactivo();
		if (Setempleado(inactivo == -1 ? NumerodeRegistro : inactivo, empleado)) {
            NumerodeRegistro++;
        }

	}


	public static Employee getUser(int i) throws IOException {
		if (i >= 0 && i <= getNumerodeRegistro()) {
			flujo.seek(i * TamanoRegistro);

			Employee a = new Employee();
			TrabajosHoras h = new TrabajosHoras();
			TrabajoBeneficio b = new TrabajoBeneficio();
		
			a.setId(UUID.fromString(flujo.readUTF()));
			a.setFirstName1(flujo.readUTF());
			a.setSecondName2(flujo.readUTF());
			a.setLastname1(flujo.readUTF());
			a.setLastname2(flujo.readUTF());
			a.setActivo(flujo.readBoolean());
			h.setHoras(Double.parseDouble(flujo.readUTF()));
			h.setHorasExtras(Double.parseDouble(flujo.readUTF()));
			a.setHoras(h);
			b.setBonificaciones(Double.parseDouble(flujo.readUTF()));
			b.setComisiones(Double.parseDouble(flujo.readUTF()));
			a.setBeneficios(b);

			return a;

		} else {
			return null;
		}
	}

	public static int buscarRegistro () throws IOException {
	 Employee e = new Employee();
      //if (Id == null) {
          //return -1;
      //}
      for (int i = 0; i < getNumerodeRegistro(); i++) {
          flujo.seek(i * TamanoRegistro);
          if (i <= getNumerodeRegistro()) {
              e = getUser(i);
             if (e.isActivo()) {
                  return i;
              }
     
         // if (result.equals(Id)) {
            
          }
      }
      
      return -1;
	  
	}
	
	public static int buscarRegistro2 (UUID Id) throws IOException {
		 Employee e=new Employee();
		 
	      if (Id == null) {
	          return -1;
	      }
	      for (int i = 0; i < getNumerodeRegistro(); i++) {
	          flujo.seek(i * TamanoRegistro);
	          
	         UUID result = getUser(i).getId();
	        
	         if (result.equals(Id) && e.isActivo()) {
	              return i;
	          }
	      }
	      return -1;
		  
		}
	
	public static boolean eliminarEmployee(UUID Id) throws IOException {
        int pos = buscarRegistro2(Id);
        if (pos == -1) {
            return false;
        }
        Employee personaEliminada = getUser(pos);
        personaEliminada.setActivo(false);
        Setempleado (pos, personaEliminada);
        return true;
    }
	
	public static Employee GetAllEmployee() throws IOException {
		
		System.out.println("Metodo de todos los empleados");
		System.out.println("Tamaño del archivo"+ getNumerodeRegistro());
		ArrayList<Employee> readEmployee = new ArrayList<Employee>();
		flujo.seek(1* TamanoRegistro);
		//System.out.println("Tamaño"+flujo());
		System.out.println("Tamaño"+flujo.readInt());
		//for (int i = 0; i< getNumerodeRegistro(); i++) {
			
			System.out.println("Lista de empleados");
			Employee a = new Employee();
			TrabajosHoras h = new TrabajosHoras();
			TrabajoBeneficio b = new TrabajoBeneficio();

			a.setId(UUID.fromString(flujo.readUTF()));
			a.setFirstName1(flujo.readUTF());
			a.setSecondName2(flujo.readUTF());
			a.setLastname1(flujo.readUTF());
			a.setLastname2(flujo.readUTF());
			h.setHoras(Double.parseDouble(flujo.readUTF()));
			h.setHorasExtras(Double.parseDouble(flujo.readUTF()));
			a.setHoras(h);
			b.setBonificaciones(Double.parseDouble(flujo.readUTF()));
			b.setComisiones(Double.parseDouble(flujo.readUTF()));
			a.setBeneficios(b);
			readEmployee.add(a);

		//}
			return a;
	}
	
}
