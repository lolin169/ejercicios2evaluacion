package unidad5;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaAutomovil {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		ArrayList<Automovil> garaje = new ArrayList<Automovil>();
		int coches = teclado.nextInt();
		for (int i = 0; i < coches; i++) {
			garaje.add(new Automovil(teclado.next(), (double) teclado.nextInt(), (double) teclado.nextInt(),
					Double.parseDouble(teclado.next())));
		}
		while (!teclado.next().equalsIgnoreCase("fin")) {
			boolean desplazamiento = true;
			String modelo = teclado.next();
			for (Automovil auto : garaje) {
				if (modelo.equalsIgnoreCase(auto.getModelo())) {
					try {
						auto.desplazar((double) teclado.nextInt());
					} catch (Exception e) {
						System.out.println("Combustible insuficiente para este desplazamiento");
						desplazamiento = false;
					}
					if (desplazamiento)
						System.out.println(String
								.format("%s %.2f %.2f", auto.getModelo(), auto.getNivel(), auto.getConsumo_trayecto())
								.replace(',', '.'));
				}
			}
		}
		System.out.println("--------------------------------------");

		for (Automovil auto : garaje) {
			System.out.println(String.format("%s %.2f %d %.2f", auto.getModelo(), auto.getNivel(), (int) auto.getKm(),
					auto.getConsumo_total()).replace(',', '.'));
		}
	}
}
