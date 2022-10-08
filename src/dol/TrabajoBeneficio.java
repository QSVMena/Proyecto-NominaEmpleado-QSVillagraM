package dol;

public class TrabajoBeneficio {

	private double Comisiones;
	private double Bonificaciones;
	
	
	public TrabajoBeneficio() {
		
	}
	
	public TrabajoBeneficio(double comision, double bonificacion) {
		Comisiones = comision;
		Bonificaciones = bonificacion;
		
	}
	
	public double getComisiones() {
		return Comisiones;
	}
	
	public void setComisiones(double comisiones) {
		Comisiones = comisiones;
	}
	
	public double getBonificaciones() {
		return Bonificaciones;
	}
	
	public void setBonificaciones(double bonificaciones) {
		Bonificaciones = bonificaciones;
	}
	
	
	
}
