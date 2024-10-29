package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Application;
import dtos.DtoClubes;
import dtos.DtoUsuario;
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
		String contrasenia = sc.next();
		club.setContrasenia(Util.encriptarContraseña(contrasenia));
		System.out.println("Indique la clave del nuevo club");
		club.setNombre(sc.next());
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		club.setFechaCreacion(LocalDate.parse(LocalDate.now().toString(), formato));

		Application.listaClubes.add(club);
	}

	@Override
	public void RegistroUsu() {
		DtoUsuario usu = new DtoUsuario();
		usu.setId(Util.aumentoIdUsus());
		System.out.println("Indique el nombre del nuevo Usuario");
		usu.setNombre(sc.next());
		System.out.println("Indique los apellidos del nuevo Usuario");
		usu.setApellidos(sc.next());
		System.out.println("Indique el correo del nuevo Usuario");
		usu.setCorreo(sc.next());
		System.out.println("Indique el DNI del nuevo Usuario");
		usu.setDni(sc.next());

		Application.listaUsuarios.add(usu);
	}

	@Override
	public void IniciarSesionUsu() {
		DtoUsuario usu = new DtoUsuario();
		System.out.println("Indique el corro del Usuario");
		String correo = sc.next();
		int aux=0;
		for (DtoUsuario comprobacion : Application.listaUsuarios) {
			if (correo.equals(comprobacion.getCorreo())) {
				System.err.println("Bienvenido a nuestra pagina");
				aux=1;
				break;
			}

		}
		if (aux==0) {
			System.out.println("No encontramos este correo en nuestra base de datos,pruebe de nuevo");
		}

	}

}

