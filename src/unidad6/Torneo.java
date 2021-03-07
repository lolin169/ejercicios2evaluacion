package unidad6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Torneo {
	static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();

	public static void main(String[] args) {

		String respuesta = teclado.nextLine();
		while (!respuesta.equalsIgnoreCase("torneo") && !respuesta.equalsIgnoreCase("fin")) {
			try {
				Scanner linea = new Scanner(respuesta);
				String nombreent = linea.next();
				String nombre = linea.next();
				String elemento = linea.next();
				int salud = linea.nextInt();
				if (linea.hasNext()) {
					System.out.println("Error, demasiados datos en la línea");
				} else {
					linea.close();
					Entrenador nuevoe = new Entrenador(nombreent);
					if (entrenadores.contains(nuevoe)) {
						entrenadores.get(entrenadores.indexOf(nuevoe)).addPokemon(addPok(nombre, elemento, salud));
					} else {
						nuevoe.addPokemon(addPok(nombre, elemento, salud));
						entrenadores.add(nuevoe);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Error, el dato no es un número entero.");
			} catch (IllegalArgumentException e) {
				System.out.println("Error, el dato no es un elemento correcto.[" + e.getMessage() + "]");
			} catch (NoSuchElementException e) {
				System.out.println("Error, número de datos inferior.");
			} catch (PokemonRepetidoException e) {
				System.out.println(
						"El pokemon introducido ya estaba en la colección de éste entrenador.[" + e.getMessage() + "]");
			}

			respuesta = teclado.nextLine();
		}
		respuesta = teclado.next();
		while (!respuesta.equalsIgnoreCase("fin") || respuesta.equalsIgnoreCase("torneo")) {

			try {
				Elemento ele = Elemento.valueOf(respuesta.toUpperCase());
				for (Entrenador e : entrenadores) {
					contieneElemento(e, ele);
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Error, el dato no es un elemento correcto.[" + respuesta + "]");
			} catch (NoSuchElementException e) {
				System.out.println("Error, número de datos inferior.");
			}
			respuesta = teclado.next();
		}
		Collections.sort(entrenadores);
		for (Entrenador e : entrenadores)
			System.out.println(e.toString());
		System.out.println("Fin.");
	}

	public static Pokemon addPok(String nombre, String elemento, int salud) {
		try {
			Elemento ele = Elemento.valueOf(elemento.toUpperCase());
			return new Pokemon(nombre, ele, salud);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(elemento);
		}
	}

	public static void contieneElemento(Entrenador e, Elemento elemento) {
		boolean contiene = false;
		for (Pokemon p : e.getPokemons()) {
			if (p.getElemento().equals(elemento))
				contiene = true;
		}
		if (contiene) {
			e.setInsignias(1);
		} else {
			Iterator<Pokemon> i = e.getPokemons().iterator();
			while (i.hasNext()) {
				Pokemon p = i.next();
				p.setSalud(-10);
				if (p.getSalud() <= 0) {
					i.remove();
				}
			}
		}
	}
}
