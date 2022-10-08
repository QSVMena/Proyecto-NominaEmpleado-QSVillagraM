package dall;
import misc.IDataController;
import dol.Employee;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.UUID;

public class EmployeeDall implements IDataController <Employee> {
	private static RandomAccessFile flujo;
	private static int NumerodeRegistro;
	private static int TamanoRegistro = 100;
	
    
	public EmployeeDall () {
		
	}
	
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


	@Override
	public void Guardar(Employee empleado) {
		
		try {
			flujo.seek(TamanoRegistro);
			flujo.writeUTF(empleado.getId().toString());
			flujo.writeUTF(empleado.getFirstName1());
			flujo.writeUTF(empleado.getSecondName2());
			flujo.writeUTF(empleado.getLastname1());
			flujo.writeUTF(empleado.getLastname2());
			flujo.writeUTF(String.valueOf(empleado.getHoras().getHoras()));
			flujo.writeUTF(String.valueOf(empleado.getHoras().getHorasExtras()));
			flujo.writeUTF(String.valueOf(empleado.getBeneficios().getBonificaciones()));
			flujo.writeUTF(String.valueOf(empleado.getBeneficios().getComisiones()));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}
		

	@Override
	public void Modificar(Employee empleado) {
			
	}

	@Override
	public void Eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Employee> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee GetId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
