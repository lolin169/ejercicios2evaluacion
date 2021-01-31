package unidad5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Mazo {

//	Ejercicio 6: Mazo

//		Definir la clase Mazo para poder representar un mazo de naipes según las especificaciones siguientes:
//		• Un objeto Mazo almacenará una colección de naipes (usar un ArrayList).
//		• Constructores:
//		o Constructor sin parámetros que crea un mazo en el que se encuentran los 13 naipes de
//		cada uno de los cuatro palos (52 naipes en total).
//		o Costructor que recibe un parámetro de n tipo int para construir un mazo formado por n
//		veces los 13 naipes de los cuatro palos (n * 52 naipes en total)
//		• Métodos de instancia:
//		o get: retorna un naipe elegido de forma aleatoria sin retirarlo del mazo.
//		o remove: retorna un naipe elegido de forma aleatoria retirándolo del mazo.
//		o add: añade un naipe al mazo.
//		o addAll: añade al mazo los naipes almacenados en una colección que se recibe a través de
//		un parámetro forma.
//		o Añadir cualesquiera métodos adicionales que se consideren útiles.

	private ArrayList<Naipe> naipes = new ArrayList<Naipe>();

	Random ran = new Random();

	public Mazo(String n) {
		for (Rango r : Rango.values()) {
			for (Palo p : Palo.values()) {
				naipes.add(new Naipe(p, r));
			}
		}
	}

	public Mazo() {
		for (Palo p : Palo.values()) {
			for (Rango r : Rango.values()) {
				naipes.add(new Naipe(p, r));
			}
		}
	}

	public Mazo(int n) {
		for (int i = 0; i < n; i++) {
			for (Palo p : Palo.values()) {
				for (Rango r : Rango.values()) {
					naipes.add(new Naipe(p, r));
				}
			}
		}
	}

	public void mostrarMazoR() {
		System.out.println("Tu Mazo mostrado por Valores es: \n");
		for (Naipe n : naipes) {
			System.out.print(n);
			if (n.getPalo().ordinal() == 3) {
				System.out.println("\n------------------------------------");
			}
		}
	}

	public void mostrarMazoP() {
		System.out.println("Tu Mazo es:\n");
		for (Naipe n : naipes) {
			System.out.print(n);
			if (n.getRango().ordinal() == 12) {
				System.out.println("");
			}
		}
		System.out.println("--------------------------------------------------------------------------"
				+ "---------------------------------");
	}

	public void mostrarMazos() {
		int contador = 1;
		int contadorM = 0;
		System.out.println("\n Mazo 1:\n---------");
		for (Naipe n : naipes) {
			if (contadorM == 52) {
				System.out.println("\n \n Mazo " + (++contador) + ":\n---------");
			}
			System.out.print(n);
			contadorM++;
			if (n.getRango().ordinal() == 12 && !(naipes.indexOf(n) == 52)) {
				System.out.println("");
			}
		}
		System.out.println("\n--------------------------------------------------------------------------"
				+ "--------------------------------------------------------------------------");
	}

	public ArrayList<Naipe> getNaipes() {
		return naipes;
	}

	public void setNaipes(ArrayList<Naipe> naipes) {
		this.naipes = naipes;
	}

	public Naipe getNaipe() {
		Naipe n = naipes.get(ran.nextInt(naipes.size()));
		return n;
	}

	public void setNaipe(Naipe n) {
		naipes.add(n);
	}

	public Naipe removeNaipeAleatorio() {
		Naipe n = naipes.remove(ran.nextInt(naipes.size()));
		return n;
	}

	public Naipe removeNaipe(String rango, String palo) {
		Naipe n = new Naipe(Palo.valueOf(palo.toUpperCase()), Rango.valueOf(rango.toUpperCase()));
		Iterator<Naipe> i = naipes.iterator();
		while (i.hasNext()) {
			Naipe r = (Naipe) i.next();
			if (r.equals(n)) {
				i.remove();
			}
		}
		System.out.println("Tu carta es:\n|" + n + "|");
		return n;
	}

	public void setNaipe() {
		Naipe n = new Naipe(Palo.values()[ran.nextInt(4)], Rango.values()[ran.nextInt(13)]);
		naipes.add((n.getValor() + (13 * (n.getPalo().ordinal()))), n);
		System.out.println("El naipe añadido al azar es:" + n + "\nEl mazo quedaría así: ");
		mostrarMazos();
	}

	public static void main(String[] args) {
		Mazo mazo = new Mazo();
		Mazo mazo1 = new Mazo("");
		Mazo mazo2 = new Mazo(2);
		mazo.mostrarMazoP();
		mazo1.mostrarMazoR();
		mazo2.mostrarMazos();
		System.out.println(mazo.getNaipe());
		mazo.removeNaipeAleatorio();
		mazo.setNaipe(new Naipe(Palo.CORAZONES, Rango.DIEZ));
		mazo.setNaipe();
	}

}
