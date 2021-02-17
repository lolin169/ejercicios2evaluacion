package unidad7;

public class Frigorífico extends Electrodoméstico {
	
	private boolean frost; 

	public Frigorífico(double preciobase, double peso) {
		super(preciobase, peso);
		marca=Marca.BEKO;
		frost=false;
	}

	public Frigorífico(double preciobase, double peso, Color color, Consumo consumo,Marca marca, String modelo, boolean frost) {
		super(preciobase, peso, color, consumo);
		this.marca=marca;
		this.modelo=modelo;
		this.frost=frost;
	}

	public boolean isFrost() {
		return frost;
	}

	@Override
	public String toString() {
		String esfrost="";
		if(frost)
			esfrost+="capacidad Frost";
		else
			esfrost+="capacidad No Frost";
		
		return "Frigorífico ["+super.toString() +", "+esfrost +"]\n";
	}
	

}
