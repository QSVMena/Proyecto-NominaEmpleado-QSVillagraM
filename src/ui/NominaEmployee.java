package ui;
import dol.Employee;
import dol.TrabajoBeneficio;
import dol.TrabajosHoras;

public class NominaEmployee {

	private Employee empleado;
	private final double INSS_LABORAL=0.07;
	
	public void SetEmployee(Employee empleado) {
		this.empleado= empleado;
	}
	
	public double SalarioAnualBruto() {
		return empleado.getSalarioMensualBruto()*12;
	}
	
	public double SalarioMensual() {
		return  empleado.getSalarioMensualBruto();
	}
	
    public double SalarioporDia() {
    	return empleado.getSalarioMensualBruto()/30;
    }
    
    //llama otra funcion
    public double SalarioHoras() {
    	return SalarioporDia()/8;
    }
	
    public double CalculoHorasExtras() {
    	return SalarioHoras()*empleado.getHoras().getHorasExtras()*2+(empleado.getHoras().getHoras()*SalarioHoras());
    }
    
    public double CalculoTotalIngresos() {
    	double ingresos= empleado.getBeneficios().getBonificaciones()+empleado.getBeneficios().getComisiones();
    	return ingresos + empleado.getSalarioMensualBruto()+CalculoHorasExtras();
    	
    }
    
    public double CalculoTotalBeneficios() {
    	return empleado.getBeneficios().getBonificaciones()+empleado.getBeneficios().getComisiones();
    }
    
    public double CalculoINSSMensual() {
    	return CalculoTotalIngresos()* INSS_LABORAL;
    }
    
    public double SalarioTotal() {
    	return CalculoTotalIngresos()-CalculoINSSMensual();    }
	
}
