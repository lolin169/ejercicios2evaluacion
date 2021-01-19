package unidad5;

import java.util.Scanner;

public class PruebaHucha {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		System.out.println("Bienvenido al Banco \n---------------------------------");
		System.out.println("Lo primero que tenemos que hacer es crear una hucha.Vamos allá!");
		Hucha hucha = new Hucha();
		do {

			System.out.println("Escoge una opción:\n\n" + "1.Crear una Hucha NUEVA..Pulse 1\n"
					+ "2.Abrir o Cerrar la Hucha..Pulse 2\n" + "3.Cambiar la CONTRASEÑA..Pulse 3\n"
					+ "4.Introducir Dinero..Pulse 4\n" + "5.Sacar Dinero..Pulse 5\n"
					+ "6.Saber el total de la Hucha..Pulse 6\n" + "7. Salir..Pulse 7");
			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				System.out.println("¿Cómo desea crear su Hucha?\n" + "1.Hucha vacía..Pulse 1\n"
						+ "2.Hucha desglosada(diciendo total,monedas y billetes a introducir)..Pulse 2\n"
						+ "3.Hucha con el total a ingresar..Pulse 3");
				int respuesta = teclado.nextInt();
				if (respuesta == 1) {
					System.out.println(hucha);
				} else if (respuesta == 2) {
					hucha.meterDinero();
					System.out.println(hucha);
				} else {
					System.out.println("Introduce en dinero a ingresar");
					hucha.meterDinerominimo(teclado.nextInt());
					System.out.println(hucha);
				}
				break;
			case 2:
				System.out.println("Abrir o Cerrar la hucha?¿");
				String abrir = teclado.next();
				if (abrir.equalsIgnoreCase("abrir"))
					hucha.abrirHucha();
				else
					hucha.cerrarHucha();
				break;
			case 3:

				hucha.setpass();

				break;
			case 4:
				System.out.println("¿Cómo desea meter dinero en su Hucha?\n" + "1.Hucha desglosada(diciendo total,monedas y billetes a introducir)..Pulse 1\n"
						+ "2.Hucha con el total a ingresar..Pulse 2");
				 respuesta = teclado.nextInt();
			    if (respuesta == 1) {
					hucha.meterDinero();
					System.out.println(hucha);
				} else {
					System.out.println("Introduce la cantidad a Ingresar");
					hucha.meterDinerominimo(teclado.nextInt());
					System.out.println(hucha);
				}
				break;
			case 5:
				System.out.println("¿Cómo desea sacar dinero en su Hucha?\n" + "1.Hucha desglosada(diciendo total,monedas y billetes a sacar)..Pulse 1\n"
						+ "2.Hucha con el total a sacar..Pulse 2");
				 respuesta = teclado.nextInt();
			    if (respuesta == 1) {
					hucha.sacarDinero();
					System.out.println(hucha);
				} else {
					System.out.println("Introduce la cantidad a RETIRAR");
					hucha.sacarDinerominimo(teclado.nextInt());
					System.out.println(hucha);
				}
				
				break;
			case 6:
				hucha.abrirHucha();
				System.out.println(hucha);
				hucha.cerrarHucha();
				break;
			}
//			Prueba rama

		} while (opcion >= 1 && opcion <= 6);
		System.out.println("Fin del programa");
	}

}
