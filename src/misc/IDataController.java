package misc;

import java.util.ArrayList;
import java.util.UUID;
//Interfaz que gestiona las operaciones CRUD
public interface IDataController <T>  {

	public void Guardar(T empleado);
	public void Modificar(T empleado);
	public void Eliminar(UUID id);
	public ArrayList<T> GetAll();
	public T GetId(UUID id);
}
