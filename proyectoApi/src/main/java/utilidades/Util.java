package utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import controladores.Application;

public class Util {
	public static long aumentoIdClubes() {
		long nuevoId;
		if (Application.listaClubes.size() == 0) {
			nuevoId = 1;
		} else {
			nuevoId = Application.listaClubes.get(Application.listaClubes.size() - 1).getId() + 1;

		}

		return nuevoId;

	}
	public static long aumentoIdUsus() {
		long nuevoId;
		if (Application.listaUsuarios.size() == 0) {
			nuevoId = 1;
		} else {
			nuevoId = Application.listaUsuarios.get(Application.listaUsuarios.size() - 1).getId() + 1;

		}

		return nuevoId;

	}

	public static String encriptarContraseña(String password) {
		try {
			// Creamos una instancia de MessageDigest con el algoritmo SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Convertimos la contraseña a bytes y generamos el hash
			byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

			// Convertimos los bytes a una cadena hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = String.format("%02x", b);
				hexString.append(hex);
			}

			// Retornamos el hash en formato de String
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
