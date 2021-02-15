package unidad7;

public class Libro extends Prestamo {

	private String autor;

	public Libro(int codigo, String titulo, int año, String autor) {
		super(codigo, titulo, año);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		String prestado = "";
		if (super.isPrestado())
			prestado += "Prestado";
		else
			prestado += "Libre";

		return "[" + super.getCodigo() + ", " + super.getTitulo() + ", " + super.getAño() + ", " + autor + ","
				+ prestado + "]";
	}

}
