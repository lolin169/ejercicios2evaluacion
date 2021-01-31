package unidad5;

import java.util.Scanner;

public class PruebaHucha {

	public static void main(String[] args) {
		
//			Hucha hucha= new Hucha();
//			hucha.meterDinero(1345);
//			System.out.println(hucha);
			Hucha hucha2 = new Hucha(9231);
			System.out.println(hucha2);
//			Hucha hucha3= new Hucha(553,10,2,1,0,1,1);
//			System.out.println(hucha3);
//			hucha3.sacarDinero(100);
//			System.out.println(hucha3);
//			hucha3.meterDinero(1, 3);
//			hucha3.sacarDinero(123);
//			System.out.println(hucha3);	
			hucha2.sacarDinero();
		
		
	}
}
