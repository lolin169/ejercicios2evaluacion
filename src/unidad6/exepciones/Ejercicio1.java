package unidad6.exepciones;

public class Ejercicio1 {
	/**
	 * Ejercicio 1 Crea una clase que defina los siguientes métodos estáticos: 
     *     • isInt(String n), que recibe una cadena en el parámetro n y retorna el valor
	 *	     booleano true si la cadena representa un número de tipo int, o el valor
     *       booleano false en caso contrario. 
     *       
	 *     • isDouble(String n), que recibe una cadena en el parámetro n y retorna el valor booleano true si la cadena representa un
	 *       número de tipo double, o el valor booleano false en caso contrario. 
	 * Da una solución basada en captura de excepciones y pon a prueba ambos métodos en el método main.
	 */
	public static void main(String[] args) /*throws NumberFormatException*/ {
          
		String n= "No";
		String n1="23";
		String n2="2.3";
		Ejercicio1.isInt(n);
		Ejercicio1.isDouble(n);
		Ejercicio1.isInt(n1);
		Ejercicio1.isDouble(n1);
		Ejercicio1.isInt(n2);
		Ejercicio1.isDouble(n2);
	}

	public static boolean isInt(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (Exception e) {
			System.out.println("isInt:"+e.getMessage());
			e.printStackTrace();
			
			return false;
		}

	}
	
	public static boolean isDouble(String n) {
		try {
			Double.parseDouble(n);
			return true;
		}catch(Exception e) {
			System.out.println("isDouble():"+(e.getMessage()));
			e.printStackTrace();
			return false;
		}
		
	}

}
