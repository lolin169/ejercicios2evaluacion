package unidad7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class PruebaEmpresa {

	public static void main(String[] args) {
		ArrayList<Pago> pagables = new ArrayList<>();
		pagables.add(new Asalariado("Juan", "Rodríguez López", LocalDate.of(2000, 03, 02), "ES0053 0493 0493 0493 0393",
				1500));
		pagables.add(new EmpresaServicios("PaquitoElectricidad", "Electricidad", "ES0043 5467 5623 0987 6754"));// Polimorfismo
		pagables.add(
				new Contratista("Miguel", "Fernández Ruiz", LocalDate.of(1991, 05, 28), "ES45 6543 3241 4357 0976"));
		((Contratista) pagables.get(2)).setEmpresa("TelecoMi", "Telecomunicaciones", 100);//Polimorfismo
//		pagables.get(2).PagarTrabajo(2000,"Telecomunicaciones");
		pagables.add(new Asalariado("Felipe", "Díaz Hernández", LocalDate.of(1998, 06, 12),
				"ES0342 2313 3467 9376 2110", 2000));

		for (Pago p : pagables) {
			if (p instanceof Asalariado)
				p.PagarTrabajo(((Asalariado) p).getSalario(), ((Asalariado) p).getNombre());//Polimorfismo
			else if (p instanceof Contratista)
				for (SociedadAnonima s : ((Contratista) p).getEmpresas()) {
					p.PagarTrabajo(s.getPrecio(), "Telecomunicaciones");
				}
			else
				p.PagarTrabajo(2000, ((EmpresaServicios) p).getNombreEmpresa());
		}

		ArrayList<Empleado> empleados = new ArrayList<>();
		for (Pago e : pagables) {
			if (e instanceof Empleado)
				empleados.add((Empleado) e);
		}

		System.out.println(empleados.toString().replace("[", "").replace("]", "").replace(",", ""));
		Collections.sort(empleados);//Se implementa la interfaz comparable en la clase Empleado para poder utilizar Collections.sort()
		System.out.println(empleados.toString().replace("[", "").replace("]", "").replace(",", ""));

	}

}
