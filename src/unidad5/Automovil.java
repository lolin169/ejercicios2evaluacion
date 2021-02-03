package unidad5;

public class Automovil {

	private double consumo_trayecto = 0;
	private String modelo;
	private double capacidad;
	private double nivel;
	private double consumo_medio;
	private double km = 0;
	private double consumo_total = 0;

	public Automovil(String modelo, double capacidad, double nivel, double consumo_medio) {
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.nivel = nivel;
		this.consumo_medio = consumo_medio;

	}

	public Automovil(String modelo, double capacidad, double consumo_medio) {
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.consumo_medio = consumo_medio;
		this.nivel = capacidad;
	}

	public void llenarDeposito() {
		this.nivel = capacidad;
	}

	public double llenarDeposito(double litros) {
		this.nivel += litros;
		if (nivel > capacidad) {
			litros = nivel - capacidad;
			nivel = capacidad;
		} else {
			litros = 0;
		}
		return litros;
	}

	public double desplazar(double km) throws Exception {
		consumo_trayecto = 0;
		if (consumo_medio * km <= nivel) {
			this.km += km;
			consumo_total += consumo_medio * km;
			consumo_trayecto += consumo_medio * km;
			nivel -= consumo_medio * km;
		} else {
			throw new Exception();
		}
		return km;
	}

	public double getConsumo_trayecto() {
		return consumo_trayecto;
	}

	public void setConsumo_trayecto(double consumo_trayecto) {
		this.consumo_trayecto = consumo_trayecto;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public double getNivel() {
		return nivel;
	}

	public void setNivel(double nivel) {
		this.nivel = nivel;
	}

	public double getConsumo_medio() {
		return consumo_medio;
	}

	public void setConsumo_medio(double consumo_medio) {
		this.consumo_medio = consumo_medio;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getConsumo_total() {
		return consumo_total;
	}

	public void setConsumo_total(double consumo_total) {
		this.consumo_total = consumo_total;
	}
}
