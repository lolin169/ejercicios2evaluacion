package unidad5;

import java.util.Scanner;

public class PruebaMazo {

	public static void main(String[] args) {

//		Escribir un programa que utilizando las clases Naipe y Mazo permita jugar a la carta más alta con el
//		ordenador como oponente, teniendo en cuenta que los naipes se ordenan de menor a mayor valor de la
//		forma siguiente: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A.
		Scanner teclado = new Scanner(System.in);
		String respuesta;
		do {
			Mazo baraja = new Mazo();
			System.out.println("Vamos a jugar a la carta más alta.\n");
			baraja.mostrarMazoP();
			System.out.println("Escoge una carta");
			Naipe jugador = baraja.removeNaipe(teclado.next(), teclado.next());
			Naipe computadora = baraja.removeNaipeAleatorio();
			System.out.println("La carta que yo he escogido es:\n|" + computadora + "|");
			baraja.mostrarMazoP();
			if ((computadora.getValor() > jugador.getValor()) && (jugador.getValor() != 1)) {
				System.out.println("Te he ganado!!");
			} else if ((jugador.getValor() < computadora.getValor()) && computadora.getValor() != 1)
				System.out.println("Me has ganado!!");
			else {
				System.out.println("Empate!!");
			}
			System.out.println("¿Jugamos de nuevo o quieres salir del juego?");
			respuesta = teclado.next();
		} while (!respuesta.equalsIgnoreCase("salir"));
		teclado.close();
		System.out.println("Fin del Juego");
	}
}
