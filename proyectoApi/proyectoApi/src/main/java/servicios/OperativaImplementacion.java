package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import controladores.Application;
import dtos.DtoClubes;
import dtos.DtoUsuario;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
		int aux = 0;
		for (DtoUsuario comprobacion : Application.listaUsuarios) {
			if (correo.equals(comprobacion.getCorreo())) {
				System.err.println("Bienvenido a nuestra pagina");
				aux = 1;
				break;
			}

		}
		if (aux == 0) {
			System.out.println("No encontramos este correo en nuestra base de datos,pruebe de nuevo");
		}

	}

	// -----------------------------------------------------------------------------------//
	private static final OkHttpClient client = new OkHttpClient(); // Inicializa el cliente aquí
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public DtoUsuario convertirJsonDesdeUrl(String url) {
		DtoUsuario usuarioDTO = null;

		try {
			Request request = new Request.Builder().url(url).build();

			// Realiza la solicitud HTTP GET
			try (Response response = client.newCall(request).execute()) {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}

				// Mapea la respuesta JSON al DTO
				usuarioDTO = objectMapper.readValue(response.body().string(), DtoUsuario.class);
			}
		} catch (IOException e) {
			e.printStackTrace(); // Manejo básico de excepciones
		}

		return usuarioDTO;
	}

	private void cambioJsonADto() {
		String url = "https://api.example.com/usuario"; // Reemplaza con la URL real
		DtoUsuario usuarioDTO = convertirJsonDesdeUrl(url);

		if (usuarioDTO != null) {
			System.out.println("ID: " + usuarioDTO.getId());
			System.out.println("Nombre: " + usuarioDTO.getNombre());
			System.out.println("Apellidos: " + usuarioDTO.getApellidos());
			System.out.println("Correo: " + usuarioDTO.getCorreo());
			System.out.println("DNI: " + usuarioDTO.getDni());
		} else {
			System.out.println("No se pudo convertir el JSON a DTO.");
		}
	}

}
