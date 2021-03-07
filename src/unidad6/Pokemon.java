package unidad6;

public class Pokemon {

	private String nombre;
	private Elemento elemento;
	private int salud;

	public Pokemon(String nombre, Elemento elemento, int salud) {
		this.nombre = nombre;
		this.elemento = elemento;
		this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud += salud;
	}

	public Elemento getElemento() {
		return elemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elemento == null) ? 0 : elemento.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (elemento != other.elemento)
			return false;
		return true;
	}

}
