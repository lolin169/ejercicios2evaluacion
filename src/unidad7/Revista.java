package unidad7;

public class Revista extends Publicación {
	int numero;
	int dia;
	int mes;

	public Revista(int codigo, String titulo, int año, int mes, int dia, int numero) {
		super(codigo, titulo, año);
		this.numero = numero;
		this.mes = mes;
		this.dia = dia;
	}

	public int getNumero() {
		return numero;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	@Override
	public String toString() {
		return "[" + super.getCodigo() + ", Número: " + numero + ", " + super.getTitulo() + ", " + super.getAño() + ", "
				+ mes + ", " + dia + "]";
	}

}
