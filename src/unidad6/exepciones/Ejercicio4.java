package unidad6.exepciones;

public class Ejercicio4 {
	public static void main(String[] args) {
		try {
			System.out.println("Antes de metodoA");
			metodoA();
			System.out.println("Despues de metodoA");//  10/ Pinta el texto al salir de metodoA()
		} catch (Exception e) {
			System.out.println("main: " + e);
		} finally {
			System.out.println("main: finally");//  11/Pinta el texto y finaliza el programa.
		}
	}

	public static void metodoA() {
		try {
			System.out.println("Antes de metodoB");
			metodoB();
			System.out.println("Despues de metodoB");//  8/Ya ha recogido la excepción, por tanto no entra en el catch.
		} catch (Exception e) {
			System.out.println("metodoA: " + e);
		} finally {
			System.out.println("metodoA: finally");//  9/Pinta el texto
		}
	}

	public static void metodoB() {
		try {
			System.out.println("Antes de metodoC");
			metodoC();  //  5/Viene con la excepción ArrayIndexOutOfBoundsException que éste catch si la recoge.
			System.out.println("Despues de metodoC");
		} catch (ArrayIndexOutOfBoundsException e) {//  6/Entra en éste catch y pinta la excepción.
			System.out.println("metodoB: " + e);
		} finally {
			System.out.println("metodoB: finally");//  7/Pinta este texto.
		}
	}

	public static void metodoC() {
		try {
			System.out.println("Antes de metodoD");
			metodoD();//  3/Acaba éste método con la excepción ArrayIndexOutOfBoundsException y al no estar recogida en el catch, va a finally de metodoC()
			System.out.println("Despues de metodoD");
		} catch (NumberFormatException e) {
			System.out.println("metodoC: " + e);
		} finally {
			System.out.println("metodoC: finally");//  4/Pasa por aquí
		}
	}

	public static void metodoD() {
		try {
			int a[] = new int[4];
			a[a.length] = a.length;//  1/Existe una exception de tipo ArrayIndexOutOfBoundsException y la lanza hasta el metodoB() que es dónde la recoge.
		} catch (ClassCastException e) {
			System.out.println("metodoD: " + e);
		} finally {
			System.out.println("metodoD: finally");//  2/Llega a finally al no ser la excepción de tipo ArrayIndexOutOfBoundsException.
		}
	}

}
