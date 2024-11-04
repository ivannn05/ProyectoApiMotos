package edu.jsia.api.servicios;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un Club como una entidad de base de datos. Esta clase mapea la
 * entidad Club a la tabla "clubs" de la base de datos.
 */

@Entity
@Table(name = "clubs")
public class Club {
	/** id del Club, automatico. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClub;
	/** Nombre del Club. */
	@Column(nullable = false)
	private String nombreClub;
	/** Email del Club. */
	@Column(nullable = false, unique = true)
	private String mailClub;
	/** Contraseña del Club. */
	@Column(nullable = false)
	private String contrasenyaClub;
	/** Colores representativos del Club. */
	private String coloresClub;
	/** Descripción del Club. */
	private String descripcionClub;
	/** Código único de localización del Club. */
	private String localizadorClub;
	/** Fecha de alta del Club. */
	private LocalDate fechaAltaClub;

	/**
	 * Getter y Setters de los campos de la identidad.
	 */
	
	/**
	 * Obtiene el ID del Club.
	 * 
	 * @return el ID del Club.
	 */
	public Long getIdClub() {
		return idClub;
	}

	/**
	 * Establece el ID del Club.
	 * 
	 * @param idClub el ID del Club.
	 */
	public void setIdClub(Long idClub) {
		this.idClub = idClub;
	}

	/**
	 * Obtiene el nombre del Club.
	 * 
	 * @return el nombre del Club.
	 */
	public String getNombreClub() {
		return nombreClub;
	}

	/**
	 * Establece el nombre del Club.
	 * 
	 * @param nombreClub el nombre del Club.
	 */
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	/**
	 * Obtiene el correo electrónico del Club.
	 * 
	 * @return el correo electrónico del Club.
	 */
	public String getMailClub() {
		return mailClub;
	}

	/**
	 * Establece el correo electrónico del Club.
	 * 
	 * @param mailClub el correo electrónico del Club.
	 */
	public void setMailClub(String mailClub) {
		this.mailClub = mailClub;
	}

	/**
	 * Obtiene la contraseña del Club.
	 * 
	 * @return la contraseña del Club.
	 */
	public String getContrasenyaClub() {
		return contrasenyaClub;
	}

	/**
	 * Establece la contraseña del Club.
	 * 
	 * @param contrasenyaClub la contraseña del Club.
	 */
	public void setContrasenyaClub(String contrasenyaClub) {
		this.contrasenyaClub = contrasenyaClub;
	}

	/**
	 * Obtiene los colores representativos del Club.
	 * 
	 * @return los colores representativos del Club.
	 */
	public String getColoresClub() {
		return coloresClub;
	}

	/**
	 * Establece los colores representativos del Club.
	 * 
	 * @param coloresClub los colores representativos del Club.
	 */
	public void setColoresClub(String coloresClub) {
		this.coloresClub = coloresClub;
	}

	/**
	 * Obtiene la descripción del Club.
	 * 
	 * @return la descripción del Club.
	 */
	public String getDescripcionClub() {
		return descripcionClub;
	}

	/**
	 * Establece la descripción del Club.
	 * 
	 * @param descripcionClub la descripción del Club.
	 */
	public void setDescripcionClub(String descripcionClub) {
		this.descripcionClub = descripcionClub;
	}

	/**
	 * Obtiene el código localizador del Club.
	 * 
	 * @return el código localizador del Club.
	 */
	public String getLocalizadorClub() {
		return localizadorClub;
	}

	/**
	 * Establece el código localizador del Club.
	 * 
	 * @param localizadorClub el código localizador del Club.
	 */
	public void setLocalizadorClub(String localizadorClub) {
		this.localizadorClub = localizadorClub;
	}

	/**
	 * Obtiene la fecha de alta del Club.
	 * 
	 * @return la fecha de alta del Club.
	 */
	public LocalDate getFechaAltaClub() {
		return fechaAltaClub;
	}

	/**
	 * Establece la fecha de alta del Club.
	 * 
	 * @param fechaAltaClub la fecha de alta del Club.
	 */
	public void setFechaAltaClub(LocalDate fechaAltaClub) {
		this.fechaAltaClub = fechaAltaClub;
	}
}
