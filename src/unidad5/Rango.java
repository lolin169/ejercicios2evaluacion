package unidad5;

public enum Rango {
	AS("AS"), DOS("2"), TRES("3"), CUATRO("4"), CINCO("5"), SEIS("6"), SIETE("7"), OCHO("8"), NUEVE("9"), DIEZ("10"),
	JACK("J"), QUEEN("Q"), KING("K");

	private String valor;

	private Rango(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}