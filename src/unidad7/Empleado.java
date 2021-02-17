package unidad7;

import java.time.LocalDate;

public abstract class Empleado implements Pago, Comparable<Object> {
	protected String nombre;
	protected String apellidos;
	private LocalDate fechaInicio;
	private String numCuenta;

	public Empleado(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		fechaInicio = LocalDate.now();

	}

	public Empleado(String nombre, String apellidos, LocalDate fechaInicio, String numCuenta) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaInicio = fechaInicio;
		this.numCuenta = numCuenta;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	@Override
	public String toString() {
		return "\n" + nombre + " " + apellidos + ", fecha de Contratación: " + fechaInicio + ", Cuenta: " + numCuenta;
	}

	public int compareTo(Object o) {
		return 0;
	}

}
