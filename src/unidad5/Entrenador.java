package unidad5;

import java.util.ArrayList;
import java.util.Iterator;

public class Entrenador {

	private String nombre;
	private int insignias;
	private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

	public Entrenador(String nombre) {
		this.nombre = nombre;
		this.insignias = 0;
	}

	public Entrenador(String nombre, ArrayList<Pokemon> pokemons) {
		this.nombre = nombre;
		insignias = 0;
		this.pokemons = pokemons;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		for (Pokemon p : pokemons) {
			System.out.println(nombre + " " + p.toString());
		}
		return nombre + " " + insignias + " " + pokemons.size();
	}

	public int getInsignias() {
		return insignias;
	}

	public void setInsignias(int insignias) {
		this.insignias += insignias;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public int getNumPokemons() {
		return pokemons.size();
	}

	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public void setPokemon(Pokemon pokemon) {
		pokemons.add(pokemon);
	}

	public boolean getElemento(String elemento) {
		boolean existe = false;
		for (Pokemon p : pokemons) {
			if (p.getElemento().equals(elemento))
				existe = true;
		}
		return existe;
	}

	public void bajarsalud() {
		Iterator<Pokemon> i = pokemons.iterator();
		while (i.hasNext()) {
			Pokemon pokemon = i.next();
			pokemon.setSalud(-10);
			if (pokemon.getSalud() < 1)
				i.remove();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}