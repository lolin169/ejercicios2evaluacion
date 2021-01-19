package unidad5;

import java.util.Scanner;

public class Hucha {
	static Scanner teclado = new Scanner(System.in);
//	Ejercicio 2: Hucha
//	Definir una clase llamada Hucha según las especificaciones siguientes:
//	• La hucha solo admite monedas de uno y dos euros y billetes de 5, 10, 20 y 50 euros.
//	• La hucha podrá estar abierta o cerrada. Para abrir o cerrar la hucha se requiere una contraseña.
//	• La contraseña se podrá cambiar en cualquier momento.
//	• La hucha podrá proporcionar información acerca de la cantidad de monedas o billetes que
//	almacena de cada clase, así como el valor total en euros.
//	• Se podrán retirar de la hucha monedas o billetes indicando el tipo y la cantidad de los mismos que
//	se desea retirar. Si la cantidad solicitada supera la cantidad almacenada se retirará únicamente la
//	cantidad disponible.
//	• Se podrá retirar de la hucha una cantidad de euros específica minimizando el número de monedas
//	y billetes que se retirarán.
//	• Se podrá construir una hucha vacía, una hucha con una cantidad específica de monedas y billetes
//	de cada tipo o una hucha con una cantidad inicial de euros que se desglosará utilizando la mínima
//	cantidad de monedas y billetes.
//	Escribir un programa que ponga a prueba la clase Hucha utilizando todos sus constructores y métodos.

	private int total = 0;
	private String pass;
	private int uno = 0;
	private int dos = 0;
	private int cinco = 0;
	private int diez = 0;
	private int veinte = 0;
	private int cincuenta = 0;
	private boolean abierta = false;

	public Hucha() {
		System.out.println("Introduce la contraseña de su hucha a crear");
		this.pass = teclado.next();

	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		System.out.println("Introduce..");
		total = teclado.nextInt();

	}

	public String getpass() {
		return pass;
	}

	public void setpass() {
		System.out.println("Introduzca la contraseña antigua");
		String pass = teclado.next();
		if (compruebaPass(pass)) {
			System.out.println("Correcto.Introduce la nueva contraseña");
			String nuevopass = teclado.next();
			System.out.println("Introduce de nuevo la nueva contraseña");
			String nuevopass2 = teclado.next();
			if (nuevopass.equals(nuevopass2)) {
				System.out.println("Contraseña modificada!!");
				this.pass = nuevopass;
			} else {
				System.out.println("Error, por seguridad, vamos a iniciar el proceso..");
				setpass();
			}
		} else {
			setpass();
		}
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta, String pass) {

		if (this.pass.equals(pass)) {
			this.abierta = true;
		}
		this.abierta = abierta;
	}

	public Hucha(int total, int uno, int dos, int cinco, int diez, int veinte, int cincuenta) {
		this.total = total;
		this.uno = uno;
		this.dos = dos;
		this.cinco = cinco;
		this.diez = diez;
		this.veinte = veinte;
		this.cincuenta = cincuenta;

	}

	@Override
	public String toString() {
		String estado;
		if (this.abierta) {
			estado = "Hucha ABIERTA";
		} else {
			estado = "Hucha CERRADA";
		}
		return "Dinero de la Hucha:\n----------------\n----------------\nTOTAL= " + total + " €uros.\n" + uno
				+ " monedas de 1 euro\n" + dos + " monedas de 2 euros\n" + cinco + " billete/s de 5 euros\n" + diez
				+ " billete/s de 10 euros\n" + veinte + " billete/s de 20 euros\n" + cincuenta
				+ " billete/s de 50 euros\nEstado=" + estado + "\n----------------\n----------------\n";
	}

	public boolean compruebaPass(String pass) {
		boolean correcto = false;
		if (pass.equals(this.pass)) {
			correcto = true;
			System.out.println("Contraseña correcta");
		}
		return correcto;
	}

	public void abrirHucha() {
		System.out.println("Introduce una contraseña correcta para ABRIR la hucha..");
		String pass = teclado.next();
		if (compruebaPass(pass)) {
			abierta = true;
			System.out.println("ABIERTA");
		} else {
			System.out.println("ERROR");
			abrirHucha();
		}
	}

	public void cerrarHucha() {
		System.out.println("Introduce una contraseña correcta para CERRAR la hucha..");
		String pass = teclado.next();
		if (compruebaPass(pass)) {
			abierta = false;
			System.out.println("CERRADA");
		} else {
			System.out.println("Error!!");
			cerrarHucha();
		}
	}

	public int[] introduceDesglose() {
		System.out.println("Introduce la cantidad de dinero total ..");
		int total = 0;
		int[] dinero = { 0, 0, 0, 0, 0, 0, 0 };
		dinero[0] = teclado.nextInt();
		System.out.println("Introduce la cantidad de monedas de € ..(total:" + total + ")");
		dinero[1] = teclado.nextInt();
		total += dinero[1];
		System.out.println("Introduce la cantidad de monedas de 2 € ..(total:" + total + ")");
		dinero[2] = teclado.nextInt();
		total += (dinero[2] * 2);
		System.out.println("Introduce la cantidad de billetes de 5 € ..(total:" + total + ")");
		dinero[3] = teclado.nextInt();
		total += (dinero[3] * 5);
		System.out.println("Introduce la cantidad de billetes de 10 € ..(total:" + total + ")");
		dinero[4] = teclado.nextInt();
		total += (dinero[4] * 10);
		System.out.println("Introduce la cantidad de billetes de 20 € ..(total:" + total + ")");
		dinero[5] = teclado.nextInt();
		total += (dinero[5] * 20);
		System.out.println("Introduce la cantidad de billetes de 50 € ..(total:" + total + ")");
		dinero[6] = teclado.nextInt();
		total += (dinero[6] * 50);

		return dinero;

	}
	
	public boolean compruebaDesglose(int[]dinero) {
		boolean correcto=true;
		int total=dinero[0];
		int suma=0;
		for (int i = 1; i < dinero.length; i++) {
			suma += dinero[i];
		}
		if (suma != dinero[0]) {
		
            correcto=false;
			System.out.println("Error, no coincide el desglose con el total a introducir, volvamos a empezar o salir?¿");
			String respuesta = teclado.next();
			if (!respuesta.equalsIgnoreCase("salir"))
				introduceDesglose();
		}
		return correcto;
		
	}

	public void meterDinero() {
		int[] dinero = introduceDesglose();
		if(!compruebaDesglose(dinero)) {
			meterDinero();
		}
		abrirHucha();
		if (this.abierta || total == 0) {
			this.total += dinero[0];
			this.uno += dinero[1];
			this.dos += dinero[2];
			this.cinco += dinero[3];
			this.diez += dinero[4];
			this.veinte += dinero[5];
			this.cincuenta += dinero[6];
		}
		cerrarHucha();
	}

	public void sacarDinero() {
		int[] dinero = introduceDesglose();
		abrirHucha();
		int suma = 0;
		for (int i = 1; i < dinero.length; i++) {
			suma += dinero[i];
		}
		if (suma >= this.total) {
			System.out.println("El dinero a sacar es mayor al que tiene la hucha, por tanto, sacamos todo el dinero..");
			dinero[0] = this.total;
			dinero[1] = this.uno;
			dinero[2] = this.dos;
			dinero[3] = this.cinco;
			dinero[4] = this.diez;
			dinero[5] = this.veinte;
			dinero[6] = this.cincuenta;

		} else {
			int total = 0;
			this.total = total;
			do {
				this.total -= dinero[0];
				if (this.cincuenta >= dinero[6]) {
					this.cincuenta -= dinero[6];
					total -= (dinero[6] * 50);
				}
				if (this.veinte >= dinero[5]) {
					this.veinte -= dinero[5];
					total -= (dinero[5] * 20);
				}
				if (this.diez >= dinero[4]) {
					this.diez -= dinero[4];
					total -= (dinero[4] * 10);
				}
				if (this.cinco >= dinero[3]) {
					this.cinco -= dinero[3];
					total -= (dinero[3] * 5);
				}
				if (this.dos >= dinero[2]) {
					this.dos -= dinero[2];
					total -= (dinero[2] * 2);
				}
				if (this.uno >= dinero[1]) {
					this.uno -= dinero[1];
					total -= dinero[1];
				}

			} while (total != 0);

		}
		cerrarHucha();
		System.out.println("El dinero sacado es:\nTOTAL= " + total + " €uros.\n" + dinero[1] + " monedas de 1 euro\n"
				+ dinero[2] + " monedas de 2 euros\n" + dinero[3] + " billete/s de 5 euros\n" + dinero[4]
				+ " billete/s de 10 euros\n" + dinero[5] + " billete/s de 20 euros\n" + dinero[6]
				+ " billete/s de 50 euros\n----------------\n----------------\n");
	}

	public void meterDinerominimo(int total) {
		abrirHucha();
		this.total += total;
		this.cincuenta += total / 50;
		total -= (total / 50) * 50;
		this.veinte += total / 20;
		total -= (total / 20) * 20;
		this.diez += total / 10;
		total -= (total / 10) * 10;
		this.cinco += total / 5;
		total -= (total / 5) * 5;
		this.dos += total / 2;
		total -= (total / 2) * 2;
		this.uno += total;
		this.abierta = false;
	}

	public void sacarDinerominimo(int total) {
		abrirHucha();
		if (total >= this.total) {
			total = this.total;
			System.out.println("El dinero sacado es:\nTOTAL= " + total + " €uros.\n" + this.uno + " monedas de 1 euro\n"
					+ this.dos + " monedas de 2 euros\n" + this.cinco + " billete/s de 5 euros\n" + this.diez
					+ " billete/s de 10 euros\n" + this.veinte + " billete/s de 20 euros\n" + this.cincuenta
					+ " billete/s de 50 euros\n----------------\n----------------\n");
			this.total = 0;
			this.uno = 0;
			this.dos = 0;
			this.cinco = 0;
			this.diez = 0;
			this.veinte = 0;
			this.cincuenta = 0;

		} else {

			int total1 = total;
			int uno, dos, cinco, diez, veinte, cincuenta;
			this.total -= total;
			cincuenta = total / 50;
			this.cincuenta -= total / 50;
			total -= (total / 50) * 50;
			veinte = total / 20;
			this.veinte -= total / 20;
			total -= (total / 20) * 20;
			diez = total / 10;
			this.diez -= total / 10;
			total -= (total / 10) * 10;
			cinco = total / 5;
			this.cinco -= total / 5;
			total -= (total / 5) * 5;
			dos = total / 2;
			this.dos -= total / 2;
			total -= (total / 2) * 2;
			uno = total;
			this.uno -= total;
			this.abierta = false;
			System.out.println("El dinero sacado es:\nTOTAL= " + total + " €uros.\n" + uno + " monedas de 1 euro\n"
					+ dos + " monedas de 2 euros\n" + cinco + " billete/s de 5 euros\n" + diez
					+ " billete/s de 10 euros\n" + veinte + " billete/s de 20 euros\n" + cincuenta
					+ " billete/s de 50 euros\n----------------\n----------------\n");
		}

		cerrarHucha();
	}

//	public boolean compruebaTotal(int totalRetira, int uno, int dos, int cinco, int diez, int veinte, int cincuenta) {
//		boolean correcto = false;
//		int suma = uno + dos + cinco + diez + veinte + cincuenta;
//		if (totalRetira == suma)
//			correcto = true;
//		return correcto;
//	}
//
//	public void sacarDinero(int totalRetira, int uno, int dos, int cinco, int diez, int veinte, int cincuenta,
//			String pass, Hucha a) {
//		do {
//			System.out.println("Comprobamos contraseña y cantidad...");
//			compruebaPass(pass);
//			compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta);
//			if (abierta && compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta)) {
//				System.out.println("Contraseña correcta y cantidad correcta.Procedemos a sacar su dinero...");
//			} else if (!abierta && compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta)) {
//				System.out.println("Introduce una contraseña correcta o SALIR");
//				pass = teclado.next();
//				if (pass.equalsIgnoreCase("salir")) {
//					break;
//				} else {
//					compruebaPass(pass);
//				}
//			} else if (abierta && !compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta)) {
//				introduceDesglose();
//				compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta);
//			}
//		} while (!abierta && !compruebaTotal(totalRetira, uno, dos, cinco, diez, veinte, cincuenta));
//		if (totalRetira < this.total && abierta) {
//			switch (uno) {
//			case 1:
//				break;
//			}
//		} else if (abierta) {
//			System.out.println("El dinero a retirar es lo que tiene la hucha\n" + a.toString());
//		}
//	}

}
