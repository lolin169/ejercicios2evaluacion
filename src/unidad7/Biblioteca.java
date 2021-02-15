package unidad7;

import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {
	static ArrayList<Publicación> publicaciones = new ArrayList<Publicación>();

	public static void main(String[] args) {

		publicaciones.add(new Libro(03, "Saber educar", 1995, "J.L.Rodríguez"));
		// Vamos introduciendo en el ArrayList de tipo Publicación diferente tipos de
		// instancias(subclases de ésta)
		Libro libreto = new Libro(02, "Aprende a relajarte", 2005, "M.D.Álvarez");
		libreto.presta();
		System.out.println(((Publicación) libreto).toString());
		// Polimorfismo, imprime Libro aunque lo hayamos casteado a Publicación.
		publicaciones.add(libreto);
		publicaciones.add(new Revista(01, "Culebrones", 2021, 02, 15, 243));
		Publicación publica = new Publicación(02, "El Barco Antiguo", 2003);
		publicaciones.add(publica);
		Collections.sort(publicaciones);
		mostrar(publicaciones);
	}

	public static void mostrar(ArrayList<Publicación> publicaciones) {
		for (Publicación p : publicaciones) // polimorfismo, tratamos las publicaciones como Publicación.
			System.out.println(p.getClass().getName().replace("unidad7.", "") + "" + p);
		/**
		 * Imprime en pantalla dependiendo de la subclase que sea y da el tratamiento
		 * como tal.
		 */
	}

}
