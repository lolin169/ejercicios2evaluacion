package unidad6;

import java.util.ArrayList;

public class Entrenador implements Comparable<Object> {

	private String nombre;
	private ArrayList<Pokemon> pokemons;
	private int insignias;

	public Entrenador(String nombre) {
		this.nombre = nombre;
		this.insignias = 0;
		pokemons = new ArrayList<>();
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public int getInsignias() {
		return insignias;
	}

	public void setInsignias(int insignias) {
		this.insignias += insignias;
	}

	public String getNombre() {
		return nombre;
	}

	public void addPokemon(Pokemon pok) throws PokemonRepetidoException {
		for (Pokemon p : pokemons) {
			if (p.getNombre().equals(pok.getNombre()))
				throw new PokemonRepetidoException(pok.getNombre());
		}
		pokemons.add(pok);
	}

	public void remove(Pokemon pok) {
		pokemons.remove(pok);
	}

	@Override
	public String toString() {
		return nombre + " " + insignias + " " + pokemons.size();
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

	@Override
	public int compareTo(Object o) {
		Entrenador e = (Entrenador) o;
		if (e.getInsignias() > this.getInsignias())
			return 1;
		else if (e.getInsignias() < this.getInsignias())
			return -1;
		else if (e.getPokemons().size() > this.pokemons.size())
			return 1;
		else if (e.getPokemons().size() < this.pokemons.size())
			return -1;
		else
			return 0;
	}

}
