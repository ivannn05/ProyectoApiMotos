package servicios;

import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.ds.PGSimpleDataSource;

public class ConexionBDImplementacion implements ConexionBDInterfaz {
	@Override
	public Connection conexionBaseDatos() {

		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		String url = "jdbc:postgresql://localhost:5432//nombre_base_datos";

		String usuario = "nombre_usuario";
		String contraseña = "contraseña";
		Connection conexion;

		try {
			// Cargar el controlador de la base de datos (opcional desde JDBC 4.0)

			Class.forName("org.postgresql.Driver");

			// Obtener la conexión usando DriverManager

			conexion = DriverManager.getConnection(url, usuario, contraseña);

			if (conexion != null) {

				System.out.println("Conexión establecida con éxito.");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			conexion = null;
		}
		return conexion;

	}
}
