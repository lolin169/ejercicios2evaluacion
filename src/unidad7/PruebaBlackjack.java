package unidad7;

import java.util.Iterator;
import java.util.Scanner;

public class PruebaBlackjack {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String respuesta = "";
		while (!respuesta.equalsIgnoreCase("fin")) {
			Blackjack juego = new Blackjack();
			System.out.println("*BLACKJACK*\nIntroduce número de jugadores");
			respuesta = teclado.nextLine();
			boolean seguir = false;
			while ((!seguir || !(juego.jugadores.size() == Integer.parseInt(respuesta)))
					&& !respuesta.equalsIgnoreCase("fin")) {
				if (!seguir) {
					try {
						Integer.parseInt(respuesta);
						seguir = true;
					} catch (NumberFormatException e) {
						System.out.println("Introduce un NÚMERO entero de jugadores");
						respuesta = teclado.nextLine();
					}
				} else {
					System.out.println("Introduce nombre del jugador:");
					juego.setjugador(new Jugador(teclado.nextLine()));
				}
			}
			juego.repartir();
			System.out.println(juego);

			while (!juego.juegoacabado() && !respuesta.equalsIgnoreCase("fin")) {
				Iterator<Jugador> i = juego.jugadores.iterator();

				while (i.hasNext() && !respuesta.equalsIgnoreCase("fin")) {
					Jugador j = i.next();

					if (!j.getFin()) {
						System.out.print("Turno para " + j.getNombre() + "\nBlackjack> ");
						respuesta = teclado.nextLine();
						try {
							switch (respuesta) {
//					case "repartir":
//						juego.repartir();
//						break;
							case "pedir":
								juego.pedir(j);
								break;
							case "plantarse":
								juego.plantarse(j);
								break;
							default:
								System.out.println("opción no válida");
							}
						} catch (RuntimeException e) {
							System.out.println(e.getMessage() + "\n" + j.getNombre());
						}
						System.out.println(juego);
					}
				}
				juego.crupier();
			}
			if (!respuesta.equalsIgnoreCase("fin")) {
				System.out.println("El resultado es:\n" + juego);
				juego.comprobarjuego();
				System.out.println("\nVolver a jugar o fin?¿");
				respuesta = teclado.nextLine();
			}
		}
		teclado.close();
		System.out.println("Fin del juego");
	}

}
