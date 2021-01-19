package unidad5;

public class PruebaAutor {

	public static void main(String[] args) {

		Autor autor1 = new Autor("Alberto Fernández", "afernandez@mail.com", Genero.masculino);
		Autor autor2 = new Autor("Juana Rodríguez", "jrodri@mail.com", Genero.femenino);
		Autor autor3 = new Autor("Felipe Sánchez", Genero.masculino);
		autor3.setEmail("fernandosz2mail.com");

		System.out.println(autor1);
		System.out.println(autor2);
		autor2.setEmail("juanarodri@mail.com");
		System.out.println("AUTOR 2:" + autor2.getNombre());
		System.out.println("GENERO:" + autor2.getGenero());
		System.out.println("EMAIL MODIFICADO:" + autor2.getEmail());
		System.out.println(autor3);

	}
}
