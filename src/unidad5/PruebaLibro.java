package unidad5;

import java.util.ArrayList;

public class PruebaLibro {

	public static void main(String[] args) {

		ArrayList<Autor> autores = new ArrayList<Autor>();
		autores.add(new Autor("Juan Dominguez", "juando@mail.com", Genero.masculino));
		autores.add(new Autor("María Patafría", "patafria@mail.com", Genero.femenino));
		Libro libro1 = new Libro("Prueba de Libro", autores, 41f);

		System.out.println(libro1);

	}

}
