package unidad7;

import java.util.ArrayList;

import unidad5.Naipe;
import unidad5.Rango;

public class Jugador implements Comparable<Object> {
	private String nombre;
	private int puntos;
	private boolean fin;
	private boolean blackjack = false;
	private int ases = 0;
	ArrayList<Naipe> cartas = new ArrayList<>();

	public Jugador(String nombre) {
		this.nombre = nombre;
		puntos = 0;
		fin = false;
	}

	public void AddCarta(Naipe naipe) {
		cartas.add(naipe);
		setPuntos(naipe);
	}

	public String getNombre() {
		return nombre;
	}

	public Naipe[] getCartas() {
		Naipe[] cards = new Naipe[14];
		for (int i = 0; i < cartas.size(); i++)
			cards[i] = cartas.get(i);
		return cards;
	}

	public void ResetCartas() {
		cartas.clear();
	}

	public void setPuntos(Naipe n) {
		if (n.getRango() == Rango.QUEEN || n.getRango() == Rango.JACK || n.getRango() == Rango.KING)
			puntos += 10;
		else if (n.getRango().equals(Rango.AS)) {
			puntos += 11;
			ases++;
		} else
			puntos += n.getRango().ordinal() + 1;
		while (puntos > 21 && ases > 0) {
			puntos -= 10;
			ases--;
		}
	}

	public int getPuntos() {
		if (Blackjack() || puntos >= 21)
			setFin(true);
		return puntos;
	}

	public void setPuntos(int i) {
		puntos = i;

	}

	public boolean getFin() {
		return fin;
	}

	public void setFin(boolean plantarse) {
		this.fin = plantarse;

	}

	public boolean Blackjack() {
		int ases = 0;
		int figura = 0;
		for (Naipe n : cartas)
			if (n.getRango().equals(Rango.AS))
				ases++;
			else if (n.getRango().equals(Rango.JACK) || n.getRango().equals(Rango.QUEEN)
					|| n.getRango().equals(Rango.KING))
				figura++;
		if (cartas.size() == 2 && figura == 1 && ases == 1)
			blackjack = true;
		return blackjack;
	}

	@Override
	public String toString() {
		return String.format(nombre + ": " + cartas + ", puntos= " + puntos).replace("[", "").replace("]", "")
				.replace(',', ' ');
	}

	public Naipe get(int i) {
		return cartas.get(i);
	}

	@Override
	public int compareTo(Object o) {
		Jugador j = (Jugador) o;
		if (!this.Blackjack() && j.Blackjack())
			return 1;
		else if (this.Blackjack() && !j.Blackjack())
			return -1;
		else if (this.getPuntos() < j.getPuntos() && (this.getPuntos() < 21 && j.getPuntos() <= 21))
			return 1;
		else if (this.getPuntos() > j.getPuntos() && (this.getPuntos() <= 21 && j.getPuntos() < 21))
			return -1;
		else
			return 0;
	}

}
