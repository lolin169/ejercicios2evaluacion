package unidad5;

import java.util.ArrayList;

/*
	 	Ejercicio 4: Libro
	 	
	Definir una clase llamada Libro según las especificaciones siguientes:
	• Atributos de instancia:
	o título, de tipo String
	o autores, de tipo Collection<Autor>
	o precio, de tipo float
	o stock, de tipo int
	• Métodos de instancia:
	o Constructor que inicialice el estado del objeto con los datos recibidos en los parámetros
	formales siguientes: título de tipo String, autores de tipo Collection<Autor> y
	precio de tipo float. El atributo stock se inicializará con el valor por defecto.
	o Constructor que inicialice todos los atributos con datos recibidos a través de parámetros
	formales.
	o Getters
	o Setters para los atributos precio y stock.
	o Redefinir el método toString para que retorne información con el formato:
	"título_libro (autor1, autor2, …) precio € - stock unidades en stock"
	Escribir un programa que ponga a prueba la clase Libro utilizando todos sus constructores y métodos.

 **/

public class Libro {

	private String titulo;
	private ArrayList<Autor> autores;
	private float precio;
	private int stock;

	public Libro(String titulo, ArrayList<Autor> autores, float precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
		stock = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public float getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

	@Override
	public String toString() {

		StringBuffer info = new StringBuffer();
		info.append("\"" + titulo + "(");

		for (Autor a : autores) {
			info.append(a.getNombre());
			info.append(",");
			}
		
		info.append(")precio: " + (int) precio + "€ - " + stock + " unidades en stock.\"");
		return info.toString();

	}

}
