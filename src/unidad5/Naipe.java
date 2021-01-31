package unidad5;

public class Naipe {

	private Palo palo;
	private Rango rango;
	private int valor;

	public Naipe(Palo palo, Rango rango, int valor) {
		this.palo = palo;
		this.rango = rango;
		this.valor = valor;
	}

	public Naipe(Palo palo, int valor) {
		this.palo = palo;
		this.valor = valor;
		this.rango = Rango.values()[valor - 1];

	}

	public Naipe(Palo palo, Rango rango) {
		this.palo = palo;
		this.valor = rango.ordinal() + 1;
		this.rango = rango;

	}

	public Naipe(String palo, String rango) {
		this.palo = Palo.valueOf(palo);
		this.valor = Integer.parseInt(rango);
		this.rango = Rango.values()[valor - 1];

	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "|" + rango.getValor() + " de " + palo.GetSimbolo() + "|";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palo == null) ? 0 : palo.hashCode());
		result = prime * result + ((rango == null) ? 0 : rango.hashCode());
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
		Naipe other = (Naipe) obj;
		if (palo != other.palo)
			return false;
		if (rango != other.rango)
			return false;
		return true;
	}

}
