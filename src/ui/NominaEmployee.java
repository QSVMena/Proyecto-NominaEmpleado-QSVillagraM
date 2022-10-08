package ui;
import dol.Employee;
import dol.TrabajoBeneficio;
import dol.TrabajosHoras;

public class NominaEmployee {

	private Employee empleado;
	private final double INSS_LABORAL=0.07;
	private double [][] TABLA_IR_PATRONAL = {
			
			{ 0.01     , 100000 , 0    , 0.00 , 0     },
			{ 100000.01, 200000 , 0    , 0.15 , 100000},
			{ 200000.01, 350000 , 15000, 0.20 , 200000},
			{ 350000.01 , 500000, 45000, 0.25 , 350000},
			{ 500000.01, -1     , 82500, 0.30 , 500000}
	};
	
	//Inyeccion de dependencia
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
    	return SalarioHoras()*empleado.getHoras().getHorasExtras()*2;
    }
    
    public double CalculoTotalIngresos() {
    	double ingresos= empleado.getBeneficios().getBonificaciones()+empleado.getBeneficios().getComisiones();
    	return ingresos + empleado.getSalarioMensualBruto()+CalculoHorasExtras();
    	
    }
    
    public double CalculoINSSMensual() {
    	return CalculoTotalIngresos()* INSS_LABORAL;
    }
    //Descuentos
    public double DeduccionInssAnual() {
    	return SalarioAnualBruto()* INSS_LABORAL;
    }
    
    public double IngresoNeto() {
    	return CalculoTotalIngresos()-(DeduccionInssAnual()/12);
    }
    
	
    //EL IR no se aplica sobre el total de salario de vengado en el año
    public double CalcularIRPatronalMensual() {
    	double Valor = SalarioAnualBruto() - DeduccionInssAnual()/12;
    	double result = 0;
    	
    	for(int i=0; i<5; i++) {
    		if(Valor >= TABLA_IR_PATRONAL[i][0]) {
    			result=TABLA_IR_PATRONAL [i][2]+(Valor-TABLA_IR_PATRONAL[i][4]);
    			result*= TABLA_IR_PATRONAL [i][3];
    		};
    	}
    	
    	return result;
    }
   
    public double GetHorasExtras(){
		return empleado.getHoras().getHorasExtras();
	}
    
    public double GetHoras() {
    	return empleado.getHoras().getHoras();
    }
    
    public double GetComisiones() {
    	return empleado.getBeneficios().getComisiones();
    }
    
    public double GetBonificaciones() {
    	return empleado.getBeneficios().getBonificaciones();
    }
    
	
}
