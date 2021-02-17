package unidad7;

public class Televisión extends Electrodoméstico {
	private int tamaño;
	private String sintonizador;	

	public Televisión(double preciobase, double peso) {
		super(preciobase, peso);
		marca=Marca.TDSYSTEMS;
		tamaño=20;
		sintonizador= "DVB-T";
		
	}

	public Televisión(double preciobase, double peso, Color color, Consumo consumo,Marca marca, String modelo, int tamaño, String sintonizador) {
		super(preciobase, peso, color, consumo);
		this.marca=marca;
		this.modelo=modelo;
		this.tamaño=tamaño;
		this.sintonizador=sintonizador;
	}

	public int getTamaño() {
		return tamaño;
	}

	public String getSintonizador() {
		return sintonizador;
	}

	@Override
	public String toString() {
		return "Televisión ["+super.toString()+", tamaño= " + tamaño + "pulgadas, sintonizador= " + sintonizador + "]\n";
	}
	

}
