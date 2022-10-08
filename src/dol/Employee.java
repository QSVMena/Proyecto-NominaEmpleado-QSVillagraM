package dol;

import java.util.UUID;

public class Employee extends Person {

	private double SalarioMensualBruto;
	private TrabajoBeneficio Beneficios;
	private TrabajosHoras Horas;
	private boolean isActivo;
	
	public boolean isActivo() {
		return isActivo;
	}

	public void setActivo(boolean isActivo) {
		this.isActivo = isActivo;
	}

	public Employee() {
		this.setId(UUID.randomUUID());
	}
	
	public TrabajoBeneficio getBeneficios() {
		return Beneficios;
	}

	public void setBeneficios(TrabajoBeneficio beneficios) {
		Beneficios = beneficios;
	}

	public TrabajosHoras getHoras() {
		return Horas;
	}

	public void setHoras(TrabajosHoras horas) {
		Horas = horas;
	}

	public double getSalarioMensualBruto() {
		return SalarioMensualBruto;
	}
	
	public void setSalarioMensualBruto(double salarioMensualBruto) {
		SalarioMensualBruto = salarioMensualBruto;
	}
	
	
}
