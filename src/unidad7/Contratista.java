package unidad7;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contratista extends Empleado {
	private ArrayList<SociedadAnonima> empresas = new ArrayList<SociedadAnonima>();

	public Contratista(String nombre, String apellidos) {
		super(nombre, apellidos);
	}

	public Contratista(String nombre, String apellidos, LocalDate fechaInicio, String numeroCuenta) {
		super(nombre, apellidos, fechaInicio, numeroCuenta);
	}

	public ArrayList<SociedadAnonima> getEmpresas() {
		return empresas;
	}

	public SociedadAnonima getEmpresa(String nombre) {
		for (SociedadAnonima s : empresas)
			if (s.getNombreEmpresa().equals(nombre))
				return (SociedadAnonima) s;
		return null;
	}

	public void setEmpresas(SociedadAnonima empresa) {
		empresas.add(empresa);
	}

	public void setEmpresas(ArrayList<SociedadAnonima> empresas) {
		this.empresas = empresas;
	}

	public void setEmpresa(String nombre, String funcion, float precio) {
		SociedadAnonima s = new SociedadAnonima(nombre, funcion, precio);
		empresas.add(s);
	}

	@Override
	public String toString() {
		return super.toString() + ".Tipo de empleado: Contratista .Empresas: " + empresas.toString();
	}

	@Override
	public void PagarTrabajo(float importe, String nombre) {
		for (SociedadAnonima s : empresas) {
			if (s.getEspecialidades().contains(nombre)) {
				System.out.println("Se ha realizado el abono de " + importe + "€ a la empresa " + s.getNombreEmpresa()
						+ " cuyo titular es el Contratista: D." + this.nombre + " " + apellidos + " en la cuenta(IBAN "
						+ getNumCuenta() + "), hoy " + LocalDate.now() + ", por concepto de: " + nombre);
			}
		}
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
