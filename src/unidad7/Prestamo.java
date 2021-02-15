package unidad7;

public abstract class Prestamo extends Publicación {
	private boolean prestado = false;

	public Prestamo(int codigo, String titulo, int año) {
		super(codigo, titulo, año);
	}

	public void presta() {
		this.prestado = true;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

}
