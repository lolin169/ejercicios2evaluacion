package unidad6.exepciones;

import java.util.Scanner;

public class Ejercicio3 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String entrada;
		double a = 0;
		double b = 0;
		do {
			entrada = teclado.nextLine();
			try {
				if (entrada.contains("A") && entrada.length() > 2) {
					a = entradaDatos(Double.parseDouble(entrada.substring(entrada.indexOf(' ') + 1)));
					System.out.println("> ");
				} else if (entrada.contains("B") && entrada.length() > 2) {
					b = entradaDatos(Double.parseDouble(entrada.substring(entrada.indexOf(' ') + 1)));
					System.out.println("> ");
				} else if (entrada.equals("C")) {
					calculaHipotenusa(a, b);
					a = 0;
					b = 0;
				} else if (!entrada.equals("F")) {
					a = 0;
					b = 0;
					System.out.println("Datos erróneos.Introduce los catetos de nuevo.");
				}
			} catch (Exception e) {
				System.out.println("Tipo de dato erróneo");
			}
		} while (!entrada.equalsIgnoreCase("F"));
		System.out.println("Fin del programa");
	}

	static double entradaDatos(double entrada) {
		if (entrada > 0)
			return entrada;
		else
			System.out.println("Datos de entrada erróneos, introduce de nuevo la orden");
		return 0;
	}

	static void calculaHipotenusa(double a, double b) {
		if (a > 0 && b > 0) {
			double hipotenusa = Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
			System.out.printf("La hipotenusa es: %.2f\n", hipotenusa);
		} else {

			System.out.println("Datos erróneos, introduce de nuevo. A es: " + a + "y B es:" + b);
		}
	}
}
