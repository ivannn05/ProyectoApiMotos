package servicios;

import dtos.DtoClubes;

public interface OperativaInterfaz {

	public void altaClub();
	public void RegistroUsu();
	public void IniciarSesionUsu();
	/**
	 * Metodo que guarda el DTO del archivo json y lo guarda en el registro de los DTO
	 */
	 public void cambioJsonADto();
	 /**
	  * Metodo que es usado en el metodo cambioJsonADto para pasarle la URL de la api y pasar el json a archivo DTO
	  * @param url
	  * @return
	  */
	 public DtoClubes convertirJsonDesdeUrl(String url);
}
