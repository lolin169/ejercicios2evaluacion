package unidad5;

import java.util.ArrayList;
import java.util.Scanner;

public class Torneo {
	private static ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String orden = teclado.nextLine();
		while (!orden.equalsIgnoreCase("fin")) {
			orden = jugar(orden);
		}
		for (Entrenador e : entrenadores)
			System.out.println(e.getNombre() + " " + e.getInsignias() + " " + e.getNumPokemons());
		System.out.println("--------------------\nFin del programa");
	}

	static String jugar(String orden) {
		boolean torneo = false;
		while (!orden.equalsIgnoreCase("fin")) {

			try {
				String[] ordenes = orden.split(" ");//comprobarDatos(orden);
				if (orden.equalsIgnoreCase("torneo")) {
					torneo = true;
				} else if (torneo && ordenes.length == 1) {
					jugada(orden);
				} else {
					torneo = false;
					Entrenador e = new Entrenador(ordenes[0]);
					if (entrenadores.contains(e)) {
						Pokemon p = new Pokemon(ordenes[1], ordenes[2], Integer.parseInt(ordenes[3]));
//						if (!(entrenadores.get(entrenadores.indexOf(e)).getPokemons().contains(p))) {
							entrenadores.get(entrenadores.indexOf(e)).setPokemon(p);
//						} else {
//							System.out.println("no se puede repetir pokemon ");
//						}
					} else {
						e.setPokemon(new Pokemon(ordenes[1], ordenes[2], Integer.parseInt(ordenes[3])));
						entrenadores.add(e);
					}
				}
			} catch (NumberFormatException e) {
				System.out.println(
						"Tipo de dato erróneo, introduzca:\nEntrenador(String) Pokemon(String) Elemento(String) Salud(Int)\nTorneo\nElemento(String)");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Número de datos erróneo,introduzca una nueva orden..");
			}
			orden = teclado.nextLine();
		}
		return orden;
	}

	static void jugada(String orden) {
		for (Entrenador e : entrenadores) {
			if (e.getElemento(orden)) {
				e.setInsignias(1);
			} else {
				e.bajarsalud();
			}
		}
	}

//	public static String[] comprobarDatos(String orden) {
//		String[] ordenes = orden.split(" ");
//		if (ordenes.length > 4 || ordenes.length < 1) {
//			System.out.println(ordenes.length);
//			System.out.println("Número de datos erróneo.");
//		} else if (ordenes.length != 1
//				&& (!iString(ordenes[0]) || !iString(ordenes[1]) || !iString(ordenes[2]) || !isInt(ordenes[3]))) {
//			System.out.println("Datos erróneos.");
//
//		}
//		return ordenes;
//	}

//	static boolean iString(String dato) {
//		try {
//			Integer.parseInt(dato);
//		} catch (NumberFormatException e) {
//			return true;
//		}
//		System.out.print("(" + dato + ")");
//		return false;
//	}
//
//	static boolean isInt(String dato) {
//		try {
//			Integer.parseInt(dato);
//			return true;
//		} catch (NumberFormatException e) {
//			System.out.print("(" + dato + ")");
//			return false;
//		}
//	}
}
