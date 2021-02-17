package unidad7;

import java.util.ArrayList;

public class SociedadAnonima extends Empresa {
	ArrayList<String> especialidades = new ArrayList<String>();
	protected float precio;

	public SociedadAnonima(String nombre, String funcion, float precio) {
		super(nombre);
		this.precio = precio;
		especialidades.add(funcion);
	}

	public ArrayList<String> getEspecialidades() {

		return especialidades;
	}

	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}

	public void setEspecialidad(String especialidad) {
		especialidades.add(especialidad);
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return super.toString() + "S.A. ";
	}

}
