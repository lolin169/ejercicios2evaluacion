package unidad6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PruebaMascota {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

	public static void main(String[] args) {
		String orden = teclado.nextLine();
		while (!orden.equals("> salir")) {
			orden = jugar(orden);
		}

		for (Mascota m : mascotas)
			System.out.println(m);
		System.out.println("--------------------");
		System.out.println("Fin del Programa");
	}

	public static String jugar(String orden) {
		String[] ordenes = orden.split(" ");
		if (!ordenes[0].equals(">")) {
			System.out.println("Entrada de datos errónea.Introduce de nuevo o > salir");
		} else {
			if (ordenes[1].equalsIgnoreCase("crear")) {
				creaMascota(ordenes[2]);
			} else if (ordenes[1].equalsIgnoreCase("comer")) {
				comeMascota(ordenes[2]);
			} else if (ordenes[1].equalsIgnoreCase("ejercicio")) {
				ejercicioMascota(ordenes[2]);
			} else if (ordenes[1].equalsIgnoreCase("dormir")) {
				duermeMascota(ordenes[2]);
			} else if (ordenes[1].equalsIgnoreCase("curar")) {
				curaMascota(ordenes[2]);
			} else {
				System.out.println("Entrada de datos errónea.Introduce de nuevo o > salir");
			}
		}
		compruebaMascota();
		orden = teclado.nextLine();
		return orden;
	}

	static boolean recorreMascotas(String nombre) {
		boolean existe = false;
		for (Mascota m : mascotas) {
			if (m.getNombre().equalsIgnoreCase(nombre))
				existe = true;
		}
		return existe;
	}

	static void creaMascota(String nombre) {
		if (recorreMascotas(nombre)) {
			System.out.println("Mascota repetida.Introduce de nuevo o fin");
		} else {
			mascotas.add(new Mascota(nombre));
		}
	}

	static boolean enfermaMascota(String nombre) {
		boolean enferma = false;
		for (Mascota m : mascotas) {
			if (m.getNombre().equalsIgnoreCase(nombre) && m.isEnferma())
				enferma = true;
		}
		return enferma;
	}

	static Mascota devuelveMascota(String nombre) {
		for (Mascota m : mascotas) {
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}

	static void comeMascota(String nombre) {
		if (recorreMascotas(nombre)) {
			if (!devuelveMascota(nombre).comer()) {
				System.out.println("No puedo comer, estoy enferm@");
			}
			devuelveMascota(nombre).Sonido();
		} else {
			System.out.println("Mascota errónea, no existe");
		}
	}

	static void ejercicioMascota(String nombre) {
		if (recorreMascotas(nombre)) {
			if (!devuelveMascota(nombre).ejercicio()) {
				System.out.println("No puedo ejercitarme, estoy enferm@");
			}
			devuelveMascota(nombre).Sonido();
		} else {
			System.out.println("Mascota errónea, no existe");
		}
	}

	static void duermeMascota(String nombre) {
		if (recorreMascotas(nombre)) {
			if (!devuelveMascota(nombre).dormir()) {
				System.out.println("No puedo dormir, estoy enferm@");
			}
			devuelveMascota(nombre).Sonido();
		} else {
			System.out.println("Mascota errónea, no existe");
		}
	}

	static void curaMascota(String nombre) {
		if (recorreMascotas(nombre)) {
			if (!devuelveMascota(nombre).curar()) {
				System.out.println("No puedo curarme, estoy San@");
			}
			String m= devuelveMascota(nombre).getNombre();
			System.out.println(m+" dice: Me he curado!");
			devuelveMascota(nombre).Sonido();
			
		} else {
			System.out.println("Mascota errónea, no existe");
		}
	}

	static void compruebaMascota() {
		Iterator<Mascota> i = mascotas.iterator();
		while (i.hasNext()) {
			Mascota m = i.next();
			if (m.getSalud() <= 0 || m.getSalud() > 55) {
				System.out.println(m.getNombre() + " no ha sobrevivido!");
				i.remove();
			}
		}
	}

	public void Sonido(Mascota m) {
		if (!m.isEnferma()) {
			if (m.getSalud() > 8 && !m.isEnferma()) {
				System.out.println(m.getNombre() + " dice: RRrrr RRrrr");
			} else if (m.getSalud() < 8 && m.getSalud() > 5 && !m.isEnferma()) {
				System.out.println(m.getNombre() + " dice: GGggg GGggg");
			} else {
				System.out.println(m.getNombre() + " dice: AAyyy AAyyy");
			}
		}else {
			System.out.println("Estoy enfermo, si no me curas no disfruto de ninguna acción");
		}
	}

}
