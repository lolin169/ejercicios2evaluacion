package unidad7;

public class Lavadora extends Electrodoméstico {
	private Carga carga;

	public Lavadora(double preciobase, double peso) {
		super(preciobase, peso);
		this.marca=Marca.BEKO;
		carga=Carga.CINCO;
	}

	public Lavadora(double preciobase, double peso, Color color, Consumo consumo, Marca marca, String modelo,Carga carga) {
		super(preciobase, peso, color, consumo);
		this.marca=marca;
		this.modelo=modelo;
		this.carga=carga;
		if(carga.getSimbolo()>8)
			super.precio+=(preciobase*0.10);
	}

	@Override
	public String toString() {
		return "Lavadora ["+super.toString()+", carga= " + carga + " kg.]\n";
	}
	
	

}
