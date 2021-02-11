package unidad6.exepciones;

public class Ejercicio5 {
	StringBuilder cadena = new StringBuilder("a");

	void metodoA() {
		try {
			cadena.append("b");//  1/cadena= ab
			metodoB();
		} catch (Exception e) {
			cadena.append("c"); //  6/cadena=abdec
		}
	}

	void metodoB() throws Exception {
		try {
			cadena.append("d");//  2/cadena=abd
			metodoC();
		} catch (Exception e) {
			throw new Exception();//  4/Lanza Exception.
		} finally {
			cadena.append("e");      // 5/cadena=abde y sale del metodoB()
		}
		cadena.append("f");
	}

	void metodoC() throws Exception {
		throw new Exception();// 3/Lanza Exception.
	}

	String getCadena() {
		return cadena.toString();
	}

	public static void main(String[] args) {
		Ejercicio5 e = new Ejercicio5(); // Creamos un objeto de tipo Ejercicio5(una cadena= "a") 
		e.metodoA();
		System.out.println(e.getCadena());// Devuelve la cadena(cadena= abdec)
	}

}
