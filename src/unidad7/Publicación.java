package unidad7;

import java.io.Serializable;

public class Publicación implements Comparable<Object>,Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String titulo;
	private int año;

	public Publicación(int codigo, String titulo, int año) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.año = año;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return "[" + codigo + ", " + titulo + ", " + año + "]";
	}

	@Override
	public int compareTo(Object o) {
		Publicación una = (Publicación) o;
		if (this.codigo < una.codigo)
			return -1;
		else if (this.codigo > una.codigo)
			return 1;
		else
			return 0;
	}

}
