package unidad7;

public abstract class Empresa {
	protected String nombreEmpresa;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreEmpresa == null) ? 0 : nombreEmpresa.hashCode());
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
		Empresa other = (Empresa) obj;
		if (nombreEmpresa == null) {
			if (other.nombreEmpresa != null)
				return false;
		} else if (!nombreEmpresa.equals(other.nombreEmpresa))
			return false;
		return true;
	}

	public Empresa(String nombre) {
		this.nombreEmpresa = nombre;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@Override
	public String toString() {
		return nombreEmpresa;
	}

}
