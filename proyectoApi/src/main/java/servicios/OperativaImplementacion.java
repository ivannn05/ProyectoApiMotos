package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Application;
import dtos.DtoClubes;
import utilidades.Util;

public class OperativaImplementacion implements OperativaInterfaz {
	Scanner sc = new Scanner(System.in);

	@Override
	public void altaClub() {

		DtoClubes club = new DtoClubes();
		club.setId(Util.aumentoIdClubes());
		System.out.println("Indique el nombre del nuevo club");
		club.setNombre(sc.next());
		System.out.println("Indique la contraseña del nuevo club");
		String contrasenia=sc.next();
		club.setContrasenia(Util.encriptarContraseña(contrasenia)); 
		System.out.println("Indique la clave del nuevo club");
		club.setNombre(sc.next());
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		club.setFechaCreacion(LocalDate.parse(LocalDate.now().toString(), formato));

		Application.listaClubes.add(club);
	}

}
