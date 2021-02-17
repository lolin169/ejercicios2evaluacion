package unidad7;

import java.time.LocalDate;

public class Asalariado extends Empleado {

	private float salario;

	public Asalariado(String nombre, String apellidos, LocalDate fechaInicio, String numeroCuenta, float salario) {
		super(nombre, apellidos, fechaInicio, numeroCuenta);
		this.salario = salario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() + ".Tipo de empleado: Asalariado, salario= " + salario;
	}

	@Override
	public void PagarTrabajo(float salario, String nombre) {
		System.out.println("Se ha realizado el abono de la nómina " + salario + "€ al trabajador Asalariado " + nombre
				+ " " + getApellidos() + " en cuenta(IBAN " + getNumCuenta() + ") a fecha de hoy " + LocalDate.now());
	}

	@Override
	public int compareTo(Object o) {
		Empleado e= (Empleado)o ;
		if(e.getFechaInicio().isBefore(this.getFechaInicio()))
			return 1;
		else if(e.getFechaInicio().isAfter(this.getFechaInicio()))
			return -1;
		else
			return 0;
	}

}
