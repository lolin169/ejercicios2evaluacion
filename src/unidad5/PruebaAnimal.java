package unidad5;

import java.time.LocalDate;

public class PruebaAnimal {

	public static void main(String[] args) {

		Animal uno = new Animal("Gato", LocalDate.of(2019, 11, 23));
		Animal dos = new Animal("Perro");
		Animal tres = new Animal();
		System.out.println("Probamos el constructor vacío para ver el nombre y fecha por defecto.Nombre: "
				+ tres.GetNombre() + ".Fecha: " + tres.GetFecha());
		tres.SetNombre("Ratón");
		tres.SetFecha(LocalDate.of(2018, 2, 3));
		System.out.println("Nombre: " + tres.GetNombre());
		System.out.println(uno);
		System.out.println(dos.toString());
	}

}
