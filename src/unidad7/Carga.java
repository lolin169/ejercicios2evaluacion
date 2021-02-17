package unidad7;

public enum Carga {
	CUATRO(4),CINCO(5),SEIS(6),SIETE(7),OCHO(8),DIEZ(10),ONCE(11),TRECE(13);
	
	private int simbolo;
	
	private Carga(int simbolo) {
		this.simbolo=simbolo;
	}

	public int getSimbolo() {
		return simbolo;
	}
	
	
}

