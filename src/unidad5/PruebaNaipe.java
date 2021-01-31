package unidad5;

public class PruebaNaipe {

	public static void main(String[] args) {

		Naipe naipe = new Naipe(Palo.CORAZONES, 1);
		System.out.println(naipe);
		System.out.println(naipe.getPalo() + "" + naipe.getPalo().GetSimbolo());
		System.out.println(naipe.getRango().ordinal() + 1);

		for (Palo e : Palo.values()) {
			System.out.print(e.GetSimbolo() + " ");
		}
		System.out.print("\n");
		for (Rango r : Rango.values()) {

			System.out.print(r.getValor() + " ");

		}

	}

}
