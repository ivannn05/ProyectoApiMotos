package dtos;

import java.time.LocalDate;

public class DtoClubes {

	Long id;
	String nombre = "aaaa";
	String correo = "aaaaa";
	String clave = "aaaa";
	String contrasenia = "aaaa";
	LocalDate fechaCreacion = LocalDate.now();

	public DtoClubes() {
		super();
	}

	public DtoClubes(Long id, String nombre,String correo, String clave, String contrasenia, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.clave = clave;
		this.contrasenia = contrasenia;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
