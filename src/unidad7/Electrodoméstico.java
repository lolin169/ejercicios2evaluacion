package unidad7;

import java.util.ArrayList;

public abstract class Electrodoméstico {

	private double preciobase;
	private Color color;
	private Consumo consumo;
	private double peso;
	protected double precio;
	protected Marca marca;
	protected String modelo;

	public Electrodoméstico(double preciobase, double peso) {
		this.preciobase = preciobase;
		this.peso = peso;
		this.color = Color.BLANCO;
		this.consumo = Consumo.F;
		precio = calculaPrecio();
	}

	public Electrodoméstico(double preciobase, double peso, Color color, Consumo consumo) {
		this.preciobase = preciobase;
		this.peso = peso;
		this.color = color;
		this.consumo = consumo;
		precio = calculaPrecio();

	}

	public double calculaPrecio() {
		double precioFin = preciobase + ((preciobase * ((consumo.ordinal() + 1) * 5)) / 100);

		if (peso <= 19)
			precioFin += (preciobase * 0.05);
		else if (peso >= 20 && peso <= 49)
			precioFin += (preciobase * 0.1);
		else if (peso >= 50 && peso <= 79)
			precioFin += (preciobase * 0.1);
		else if (peso >= 80)
			precioFin += (preciobase * 0.2);

		return precioFin;
	}

	public double getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(double preciobase) {
		this.preciobase = preciobase;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Color getColor() {
		return color;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public double getPeso() {
		return peso;
	}
	

	public Marca getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return marca+", modelo= "+ modelo+", precio base= " + preciobase + " €, color= " + color + ", consumo= " + consumo + ", peso= " + peso
				+ "kg., precio= " + precio+" €";
	}

	public static void main(String[] args) {
		ArrayList<Electrodoméstico> electrodomesticos= new ArrayList<Electrodoméstico>();

		Electrodoméstico ele = new Lavadora(100, 80, Color.ROJO, Consumo.B, Marca.ZANUSSI, "ZN567", Carga.DIEZ);
		electrodomesticos.add(ele);
		electrodomesticos.add(new Televisión(400, 20, Color.NEGRO, Consumo.C,Marca.XIAOMI,"MI LED TV 4S 55", 50, "DVB-T2"));
		electrodomesticos.add(new Televisión(400, 20));
		Electrodoméstico ele1= new Frigorífico(600, 110, Color.GRIS, Consumo.F,Marca.ZANUSSI, "ZS-Combi556", true);
		electrodomesticos.add(new Frigorífico(350,70));
		electrodomesticos.add(ele1);
		System.out.println(String.format(electrodomesticos.toString()).replace("[", " ").replace(", "," ").replace(']', ' '));
		((Frigorífico) ele1).isFrost(); //Polimorfismo
		System.out.println(ele1.getClass().getSimpleName());
		
		
	}

}
