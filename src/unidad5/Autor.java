/**
 * Ejercicio 3: Autor
Definir una clase llamada Autor según las especificaciones siguientes:
• Atributos de instancia:
o nombre, de tipo String
o email, de tipo String
o género (para almacenar el género: masculino o femenino), de tipo String
• Métodos de instancia:
o constructor que inicialice el estado del objeto con los valores que reciba a través de sus
parámetros formales.
o Getters para obtener el nombre, el email y el género de una instancia de la clase.
o Setter para cambiar el correo electrónico de las instancias de la clase.
o Redefinir el método toString para que retorne una cadena que contenga una breve
descripción del estado del objeto que lo invoca con el formato: "nombre_autor
(género) email". Ejemplo:
"Alberto Fernández (masculino) afernandez@mail.com"
Escribir un programa que ponga a prueba la clase Autor utilizando todos sus constructores y métodos.
 */
package unidad5;

public class Autor {

	private String nombre;
	private String email;
	private Genero genero;

	public Autor(String nombre, String email, Genero genero) {

		this.nombre = nombre;
		this.email = email;
		this.genero = genero;
	}

	public Autor(String nombre, Genero genero) {

		this.nombre = nombre;
		this.genero = genero;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return "\"" + nombre + " (" + genero + ") " + email + "\"";
	}

}
