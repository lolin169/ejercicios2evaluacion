package unidad6;

import java.util.Random;

public class Mascota {

	private String nombre;
	private int salud;
	private boolean enferma = false;

	public Mascota(String nombre) {
		this.nombre = nombre;
		salud = 20;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public boolean isEnferma() {
		if(enferma) {
		return true;
		}else {
		return false;
		}
	}

	public void setEnferma() {
		this.enferma = true;
	}
	
	
 
	@Override
	public String toString() {
		String enferm;
		if(enferma) {
			enferm= "enferm@";
		}else {
			enferm="Estoy san@";
		}
		return  nombre + " Salud:" + salud + " ("+ enferm +")" ;
	}

	public boolean comer() {
		boolean come=true;
		Random ran = new Random();
		int aleatorio = ran.nextInt(10) + 1;                                                 
		if (!enferma) {
			this.salud += 5;
			if (aleatorio == 3 || aleatorio == 6 || aleatorio == 9) {
				this.salud -= 10;
				enferma = true;
				System.out.println("Comida en mal estado.Me he puesto enferm@");
			}
		} else {
			this.salud -= 1;
			come = false;
		}
		comprobarSalud();
		return come;
	}

	public boolean dormir() {
		boolean duerme= true;
		if (!enferma) {
			this.salud += 2;
		} else {
			this.salud -= 1;
			duerme = false;
		}
		comprobarSalud();
		return duerme;

	}

	public boolean ejercicio() {
		boolean suda= true;
		if (!enferma) {
			this.salud -= 3;
		} else {
			this.salud -= 1;
			suda=false;
		}
		comprobarSalud();
		return suda;
	}

	public boolean curar() {
		boolean cura=true;
		if(enferma) {
		this.salud = 20;
		enferma = false;
		}else {
			cura=false;
		}
		return cura;
	}

	public void Sonido() {
		if (salud > 8 && !enferma) {
			System.out.println(nombre+" dice: RRrrr RRrrr");
		} else if (salud < 8 && salud > 5 && !enferma) {
			System.out.println(nombre+" dice: GGggg GGggg");
		} else {
			System.out.println(nombre+" dice: AAyyy AAyyy");
		}
	}

	public void comprobarSalud() {
		if (salud > 50 || salud < 5) {
			enferma = true;
		} else {
			enferma = false;
		}
	}
}
