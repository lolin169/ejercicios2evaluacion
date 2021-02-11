package unidad6.exepciones;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce los coeficientes de la ecuación:..a b c");
		try {
			double[] coeficientes = { teclado.nextDouble(), teclado.nextDouble(), teclado.nextDouble() };
			double[] solucion = Ejercicio2.resuelve(coeficientes[0], coeficientes[1], coeficientes[2]);
			System.out.printf("%5.2f  %5.2f", solucion[0], solucion[1]);
		} catch (IllegalArgumentException e) {
			System.out.println("El coeficiente de mayor grado es cero");
			e.printStackTrace();

		} catch (ArithmeticException e) {
			System.out.println("El discriminante es negativo");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Error de datos");
			e.printStackTrace();

		}
		teclado.close();
	}

	public static double[] resuelve(double a, double b, double c) {

		if (a == 0) {
			throw new IllegalArgumentException();
		}
		double d;
		d = Math.pow(b, 2) - (4 * (a * c));
		if (d < 0) {
			throw new ArithmeticException();
		}
		double sol = (-b) + (Math.sqrt(d));
		sol /= 2 * a;
		double sol1 = (-b) - (Math.sqrt(d));
		sol1 /= 2 * a;
		double[] solucion = { sol, sol1 };

		return solucion;
	}

}
