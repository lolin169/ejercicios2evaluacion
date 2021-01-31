package unidad5;

public enum Palo {
	PICAS('\u2660'), CORAZONES('\u2665'), TREBOLES('\u2663'), DIAMANTES('\u2666');

	private char simbolo;

	private Palo(char simbolo) {
		this.simbolo = simbolo;
	}

	public char GetSimbolo() {
		return simbolo;
	}

}
