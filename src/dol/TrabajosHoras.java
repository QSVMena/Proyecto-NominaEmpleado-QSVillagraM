package dol;

public class TrabajosHoras {

	private double Horas;
	private double HorasExtras;
	
	public TrabajosHoras() {
		
	}
	
	public TrabajosHoras(double horas, double horasExtras) {
		Horas = horas;
		HorasExtras = horasExtras;
	}
	
	public double getHoras() {
		return Horas;
	}
	
	public void setHoras(double horas) {
		Horas = horas;
	}
	
	public double getHorasExtras() {
		return HorasExtras;
	}
	
	public void setHorasExtras(double horasExtras) {
		HorasExtras = horasExtras;
	}
}
