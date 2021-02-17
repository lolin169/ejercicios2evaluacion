package unidad7;

import java.time.LocalDate;

public class EmpresaServicios extends Empresa implements Pago {

	private String funcion;
	private String numeroCuenta;

	public EmpresaServicios(String nombre, String funcion, String numeroCuenta) {
		super(nombre);
		this.funcion = funcion;
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getFuncion() {
		return funcion;
	}

	@Override
	public void PagarTrabajo(float importe, String nombre) {
		System.out.println("Se ha realizado el abono de " + importe + "€ a la Empresa de Servicios " + nombreEmpresa
				+ " en cuenta(IBAN " + numeroCuenta + "), hoy " + LocalDate.now() + " por servicios de: " + funcion
				+ ".");
	}

	@Override
	public String toString() {
		return super.toString() + "Empresa de Servicios(" + funcion + ")";
	}

}
