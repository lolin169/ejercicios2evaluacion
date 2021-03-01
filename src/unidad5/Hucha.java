package unidad5;

import java.util.Scanner;

public class Hucha {
	Scanner teclado = new Scanner(System.in);
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

	public static final int CINCUENTA = 0;
	public static final int VEINTE = 1;
	public static final int DIEZ = 2;
	public static final int CINCO = 3;
	public static final int DOS = 4;
	public static final int UNO = 5;
	private String pass;
	private boolean abierta = false;
	private int[] cambio = { 50, 20, 10, 5, 2, 1 };
	private int[] desglose = new int[cambio.length];
	private int total = 0;
	private String nombre = "";

	public Hucha() {
		System.out.println("Introduce la contraseña de su hucha a crear");
		this.pass = teclado.nextLine();
		System.out.println("Introduce el nombre de su hucha a crear");
		this.nombre = teclado.nextLine();
		System.out.println("Hucha Creada");
	}

	public Hucha(int total) {
		this();
		meterDinero(total);
		System.out.println("Hucha Creada");
	}

	public Hucha(int cincuenta, int veinte, int diez, int cinco, int dos, int uno) {
		this();
		desglose[0] = cincuenta;
		desglose[1] = veinte;
		desglose[2] = diez;
		desglose[3] = cinco;
		desglose[4] = dos;
		desglose[5] = uno;
		total = getTotal();
	}

	public int getTotal() {
		for (int i = 0; i < desglose.length; i++)
			total += desglose[i] * cambio[i];
		return total;
	}

	public void setTotal() {
		System.out.println("Introduce el total que ha de tener la hucha..");
		total = teclado.nextInt();
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

	@Override
	public String toString() {
		String estado;
		if (abierta) {
			estado = "Hucha ABIERTA";
		} else {
			estado = "Hucha CERRADA";
		}
		return "Dinero de la Hucha de " + nombre + ":\n----------------\n----------------\nTOTAL= " + total
				+ " €uros.\n" + desglose[Hucha.UNO] + " moneda/s de 1 euro\n" + desglose[Hucha.DOS]
				+ " moneda/s de 2 euros\n" + desglose[Hucha.CINCO] + " billete/s de 5 euros\n" + desglose[Hucha.DIEZ]
				+ " billete/s de 10 euros\n" + desglose[Hucha.VEINTE] + " billete/s de 20 euros\n"
				+ desglose[Hucha.CINCUENTA] + " billete/s de 50 euros\nEstado=" + estado
				+ "\n----------------\n----------------\n";
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

	public void introduceDesglose() {
		int metido = 0;
		int[] dinero = { 0, 0, 0, 0, 0, 0 };
		System.out.println("Introduce la cantidad de monedas de € ..(total:" + total + ")");
		dinero[5] = teclado.nextInt();
		System.out.println("Introduce la cantidad de monedas de 2 € ..(total:" + total + ")");
		dinero[4] = teclado.nextInt();
		System.out.println("Introduce la cantidad de billetes de 5 € ..(total:" + total + ")");
		dinero[3] = teclado.nextInt();
		System.out.println("Introduce la cantidad de billetes de 10 € ..(total:" + total + ")");
		dinero[2] = teclado.nextInt();
		System.out.println("Introduce la cantidad de billetes de 20 € ..(total:" + total + ")");
		dinero[1] = teclado.nextInt();
		System.out.println("Introduce la cantidad de billetes de 50 € ..(total:" + total + ")");
		dinero[0] = teclado.nextInt();
		for (int i = 0; i < dinero.length; i++) {
			metido += dinero[i] * cambio[i];
			desglose[i] += dinero[i];
		}
		System.out.println("Has metido a la hucha " + metido + " €");
	}

	public boolean compruebaDesglose(int[] dinero, int total) {
		boolean correcto = true;
		int suma = 0;
		for (int i : dinero) {
			suma += i;
		}
		if (suma != total) {
			correcto = false;
			System.out.println("Error, no coincide el desglose con el total, volvamos a empezar o salir?¿");
			String respuesta = teclado.next();
			if (!respuesta.equalsIgnoreCase("salir"))
				introduceDesglose();
		}
		return correcto;
	}

	public void meterDinero(int[] dinero) {
		abrirHucha();
		for (int i = 0; i < cambio.length; i++) {
			desglose[i] += dinero[i];
			this.total += dinero[i] * cambio[i];
		}
		abierta = false;
	}

	public void meterDinero(int total) {
		abrirHucha();
		this.total += total;
		for (int i = 0; i < cambio.length; i++) {
			if (total >= cambio[i]) {
				desglose[i] += (total / cambio[i]);
				total %= cambio[i];
			}
		}
		this.abierta = false;
	}

	public void meterDinero(int tipo, int cantidad) {
		if (tipo == 50)
			tipo = 0;
		else if (tipo == 20)
			tipo = 1;
		else if (tipo == 10)
			tipo = 2;
		else if (tipo == 5)
			tipo = 3;
		else if (tipo == 2)
			tipo = 4;
		else if (tipo == 1)
			tipo = 5;
		this.desglose[tipo] += cantidad;
		total += cantidad * cambio[tipo];
		System.out.println(this);
	}

	public void meterDinero() {
		int[] meter = new int[cambio.length];
		int sum = 0;
		abrirHucha();
		if (abierta) {
			System.out.println("Introduce la cantidad de monedas de € ..(total:" + sum + ")");
			meter[5] = teclado.nextInt();
			sum += meter[5];
			desglose[5] += meter[5];
			System.out.println("Introduce la cantidad de monedas de 2€ ..(total:" + sum + ")");
			meter[4] = teclado.nextInt();
			sum += meter[4] * 2;
			desglose[4] += meter[4];
			System.out.println("Introduce la cantidad de billetes de 5€ ..(total:" + sum + ")");
			meter[3] = teclado.nextInt();
			sum += meter[3] * 5;
			desglose[3] += meter[3];
			System.out.println("Introduce la cantidad de billetes de 10€ ..(total:" + sum + ")");
			meter[2] = teclado.nextInt();
			sum += meter[2] * 10;
			desglose[2] += meter[2];
			System.out.println("Introduce la cantidad de billetes de 20€ ..(total:" + sum + ")");
			meter[1] = teclado.nextInt();
			sum += meter[1] * 20;
			desglose[1] += meter[1];
			System.out.println("Introduce la cantidad de billetes de 50€ ..(total:" + sum + ")");
			meter[0] = teclado.nextInt();
			sum += meter[0] * 50;
			desglose[0] += meter[0];
			total += sum;
			abierta = false;
		} else {
			System.out.println("Hucha cerrada, dinero no introducido");
		}
	}

	public void sacarDinero(int total) {
		int[] dinero = new int[cambio.length];
		if (total >= this.total) {
			total = this.total;
			this.total = 0;
			for (int i = 0; i < cambio.length; i++) {
				dinero[i] = desglose[i];
				desglose[i] = 0;
			}

		} else {
			for (int i = 0; i < cambio.length; i++) {
				if ((total / cambio[i] <= desglose[i]) && desglose[i] > 0) {
					desglose[i] -= total / cambio[i];
					dinero[i] += total / cambio[i];
					total -= dinero[i] * cambio[i];
					this.total -= dinero[i] * cambio[i];
				}
			}
		}
		cerrarHucha();
		Resumen(dinero);
	}

	public void Resumen(int[] dinero) {
		int total = (dinero[0] * 50) + (dinero[1] * 20) + (dinero[2] * 10) + (dinero[3] * 5) + (dinero[4] * 2)
				+ (dinero[5]);
		System.out.println("El dinero sacado es:\nTOTAL= " + total + " €uros.\n" + dinero[5] + " moneda/s de 1 euro\n"
				+ dinero[4] + " moneda/s de 2 euros\n" + dinero[3] + " billete/s de 5 euros\n" + dinero[2]
				+ " billete/s de 10 euros\n" + dinero[1] + " billete/s de 20 euros\n" + dinero[0]
				+ " billete/s de 50 euros\n----------------\n----------------\n");
	}

	public void sacarDinero() {
		abrirHucha();
		int[] sacar = new int[cambio.length];
		int sum = 0;
		System.out.println("Introduce la cantidad de monedas de € a sacar ..(total:" + sum + ")");
		sacar[5] = teclado.nextInt();
		sum += sacar[5];
		System.out.println("Introduce la cantidad de monedas de 2€ a sacar..(total:" + sum + ")");
		sacar[4] = teclado.nextInt();
		sum += sacar[4] * 2;
		System.out.println("Introduce la cantidad de billetes de 5€ a sacar ..(total:" + sum + ")");
		sacar[3] = teclado.nextInt();
		sum += sacar[3] * 5;
		System.out.println("Introduce la cantidad de billetes de 10€ sacar ..(total:" + sum + ")");
		sacar[2] = teclado.nextInt();
		sum += sacar[2] * 10;
		System.out.println("Introduce la cantidad de billetes de 20€ a sacar ..(total:" + sum + ")");
		sacar[1] = teclado.nextInt();
		sum += sacar[1] * 20;
		System.out.println("Introduce la cantidad de billetes de 50€ a sacar ..(total:" + sum + ")");
		sacar[0] = teclado.nextInt();
		sum += sacar[0] * 50;

		if (sum >= this.total) {
			sum = this.total;
			this.total = 0;
			for (int i = 0; i < cambio.length; i++) {
				sacar[i] = desglose[i];
				desglose[i] = 0;
			}
		} else {
			for (int i = 0; i < cambio.length; i++) {
				if (sacar[i] >= desglose[i]) {
					sacar[i] = desglose[i];
					desglose[i] = 0;
					this.total -= (sacar[i] * cambio[i]);

				} else {
					desglose[i] -= sacar[i];
					this.total -= (sacar[i] * cambio[i]);
				}
				sum -= (sacar[i] * cambio[i]);
			}
		}
		abierta = false;
		Resumen(sacar);
		if (sum != 0) {
			System.out.println("No se ha podido sacar " + sum + "€ por no haber tipo de moneda/billete adecuados.");
		}
		System.out.println(this);
	}
}
