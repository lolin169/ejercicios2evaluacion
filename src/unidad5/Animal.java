package unidad5;

import java.time.LocalDate;

public class Animal {

	private String nombre;
	private LocalDate fecha;

	public Animal(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public Animal(String nombre) {
		this.nombre = nombre;
		fecha = LocalDate.now();
	}

	public void SetNombre(String nombre) {
		this.nombre = nombre;
	}

	public String GetNombre() {
		return nombre;
	}

	public void SetFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate GetFecha() {
		return fecha;
	}

	public String toString() {
		int edad = LocalDate.now().getYear() - fecha.getYear();
		return "\"Nombre: " + nombre + " - Edad: " + edad + "\"";
	}

	public Animal() {

	}
}
