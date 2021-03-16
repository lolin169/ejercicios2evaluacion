package unidad7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Blackjack {
	ArrayList<Jugador> jugadores = new ArrayList<>();
	Jugador crupier = new Jugador("Crupier");
	Mano baraja = new Mano(6);
	static Random ran = new Random();
	static String[] ganadores;

	public void repartir() {
		if (jugadores.get(0).getPuntos() == 0) {
			crupier.AddCarta(baraja.getNaipe());
			crupier.AddCarta(baraja.getNaipe());
			for (Jugador j : jugadores) {
				if (!j.getFin() && j.getPuntos() < 21) {
					j.AddCarta(baraja.getNaipe());
					j.AddCarta(baraja.getNaipe());
				} else
					j.setFin(true);
			}
		} else {
			throw new RuntimeException("No se puede repartir");
		}

	}

	public void pedir(Jugador j) {
		if (!j.getFin() && j.cartas.size() >= 2) {
			if (!j.getFin())
				j.AddCarta(baraja.getNaipe());
			if (j.getPuntos() == 21 || j.Blackjack()) {
				j.setFin(true);
				System.out.println(j.getNombre() + " se ha PLANTADO");
			} else if (j.getPuntos() > 21) {
				j.setFin(true);
				System.out.println(j.getNombre() + " se ha PASADO");
			}
		} else {
			throw new RuntimeException("No se puede pedir");
		}
	}

	public void crupier() {
		if (crupier.getPuntos() < 17) {
			crupier.AddCarta(baraja.getNaipe());
		} else {
			crupier.setFin(true);
		}
	}

	public void plantarse(Jugador j) {
		if (!juegoacabado() && !j.getFin()) {
			j.setFin(true);
			System.out.println(j.getNombre() + " se ha PLANTADO");

		} else
			throw new RuntimeException("No se puede plantar");
	}

	public boolean juegoacabado() {
		boolean acabado = false;
		int numero = 0;
		if (crupier.getFin())
			numero++;
		for (Jugador j : jugadores) {
			if (j.getFin())
				numero++;
		}
		if (numero > jugadores.size())
			acabado = true;
		return acabado;
	}

	public void setjugador(Jugador j) {
		jugadores.add(j);
	}

	public void ExceptionManoAcabada() {
	}

	public Jugador get(int i) {
		return jugadores.get(i);
	}

	public void comprobarjuego() {
		int puntosmax = 0;
		ArrayList<Jugador> ganadores = new ArrayList<>();
		jugadores.add(crupier);
		for (Jugador j : jugadores) {
			if (j.getPuntos() > 21)
				j.setFin(true);
			else {
				if (j.Blackjack()) {
					puntosmax = 21;
				} else if (j.getPuntos() > puntosmax)
					puntosmax = j.getPuntos();
			}
		}

		Iterator<Jugador> i = jugadores.iterator();
		while (i.hasNext()) {
			Jugador j = (Jugador) i.next();
			if (j.getPuntos() > puntosmax && j.getPuntos() <= 21)
				ganadores.add(j);
			else if (j.getPuntos() == puntosmax && j.getPuntos() <= 21)
				ganadores.add(j);
			else
				ganadores.remove(j);
		}

		if (ganadores.size() > 1) {
			int blackjack = 0;
			for (Jugador j : ganadores) {
				if (j.Blackjack())
					blackjack++;
			}
			if (blackjack == 1)
				System.out.print("Ha ganado ");
			else if (blackjack > 1)
				System.out.print("EMPATE ");
			else
				System.out.print("EMPATE ");

			for (Jugador j : ganadores) {
				if (blackjack == 1 && j.Blackjack()) {
					System.out.println(j.getNombre() + " (BLACKJACK!!)");
					ganadores.clear();
				} else if (blackjack > 1 && j.Blackjack()) {
					System.out.print(j.getNombre() + " (BLACKJACK!!) ");
				} else if (blackjack == 0) {
					System.out.print(j.getNombre() + " ");
				}
			}
		} else
			System.out.println("Ha ganado " + ganadores.get(0).getNombre());

	}

	@Override
	public String toString() {
		String respuesta = "";
		if (crupier.cartas.size() == 0)
			respuesta += "";
		else if (!juegoacabado())
			respuesta += "Crupier: " + crupier.get(0).toString() + "\n";
		else {
			respuesta += "Crupier: " + crupier.cartas + " (" + crupier.getPuntos() + " puntos)\n";
		}
		for (Jugador j : jugadores)
			if (j.cartas.size() > 0)
				respuesta += j.getNombre() + ": " + j.cartas + " (" + j.getPuntos() + " puntos)\n";

		return respuesta.replace("[", "").replace("]", "").replace(",", "");
	}

//	public ArrayList<Jugador> gana() {
//		int puntos=0;
//		ArrayList <Jugador> gana= new ArrayList<>();
//		for(Jugador j:jugadores) {
//			if(j.getPuntos()<=21&& j.getPuntos()>=puntos)
//				puntos=j.getPuntos();	
//		}
//		ArrayList<Jugador>ganadores= new ArrayList<>();
//		int blacjack=0;
//		for(Jugador j:jugadores){
//			if(j.Blackjack())
//				blackjack++;
//		}
//		
//		if(blackjack==0){
//			for(Jugador j:jugadores){
//				if(j.getPuntos()==puntos)
//						ganadores.add(j)
//			}
//		}
//		if(blackjack!=0){
//			for(Jugador j:jugadores){
//				if(j.Blackjack())
//					 ganadores.add(j)
//			}
//		}
//		return ganadores;
//	}

}
