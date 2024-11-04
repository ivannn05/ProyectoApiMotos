package edu.jsia.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones CRUD de la entidad Club.
 * Expone endpoints para obtener, crear, actualizar y eliminar clubes.
 */
@RestController
@RequestMapping("/clubs")
public class ClubController {
	 /** Servicio para realizar operaciones relacionadas con los clubes */
	@Autowired
	private ClubService clubService;
	  /**
     * Obtiene la lista completa de clubes.
     * 
     * @return una lista de todos los clubes.
     */
	@GetMapping
	public List<Club> getAllClubs() {
		return clubService.getAllClubs();
	}
	 /**
     * Obtiene un club específico por su ID.
     * 
     * @param id el ID del club a buscar.
     * @return el club encontrado, o un error 404 si no existe.
     */
	@GetMapping("/{id}")
	public ResponseEntity<Club> getClubById(@PathVariable Long id) {
		return clubService.getClubById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	 /**
     * Crea un nuevo club en el sistema.
     * 
     * @param club el objeto Club a crear.
     * @return el club creado.
     */
	@PostMapping
	public Club createClub(@RequestBody Club club) {
		return clubService.createClub(club);
	}
	 /**
     * Actualiza un club existente.
     * 
     * @param id el ID del club a actualizar.
     * @param clubDetails los nuevos detalles del club.
     * @return el club actualizado, o un error 404 si no existe.
     */
	@PutMapping("/{id}")
	public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club clubDetails) {
		try {
			return ResponseEntity.ok(clubService.updateClub(id, clubDetails));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	 /**
     * Elimina un club específico.
     * 
     * @param id el ID del club a eliminar.
     * @return una respuesta sin contenido si la eliminación fue exitosa.
     */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
		clubService.deleteClub(id);
		return ResponseEntity.noContent().build();
	}
}
