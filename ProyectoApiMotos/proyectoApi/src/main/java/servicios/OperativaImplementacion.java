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
		
		System.out.println("Indique el correo del nuevo club");
		club.setCorreo(sc.next());
		
		System.out.println("Indique la contraseña del nuevo club");
		String contrasenia = sc.next();
		
		club.setContrasenia(Util.encriptarContraseña(contrasenia));
		System.out.println("Indique la clave del nuevo club");
		club.setClave(sc.next());
		/*
		 * DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * club.setFechaCreacion(LocalDate.parse(LocalDate.now().toString(), formato));
		 */
		club.setFechaCreacion(LocalDate.now());
		Application.listaClubes.add(club);
	}

	public void bajaClub() {
		// Boean que mantiene el while activo
		boolean cerrar = false;
		while (!cerrar) {
			System.out.println("Que club desea eliminar: (Correo)");
			String correoEliminar = sc.next();
			for (DtoClubes club : Application.listaClubes) {
				if (correoEliminar.toLowerCase().equals(club.getCorreo().toLowerCase())) {
					System.out.println("¿Desea eliminar este club? 1>si/2>no");
					System.out.println("--> " + club.getNombre() + " " + club.getCorreo());
					int decision = sc.nextInt();
					if (decision == 1) {
						// Se elimina de la lista
						Application.listaClubes.remove(correoEliminar);
						System.out.println("Club eliminado con exito");
						// Cierra el bucle
						cerrar = true;
					}
				}
			}
		}

		/*
		 * Variables Long id; String nombre = "aaaa"; String clave = "aaaa"; String
		 * contrasenia = "aaaa"; LocalDate fechaCreacion = LocalDate.now();
		 */
	}

}
