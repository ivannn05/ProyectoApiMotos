package edu.jsia.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsia.api.Repositorys.*;

import java.util.List;
import java.util.Optional;
/**
 * Servicio que proporciona la lógica de negocio para gestionar clubes,
 * utiliza el repositorio para interactuar con la base de datos.
 */
@Service
public class ClubService {
	 /** Repositorio para realizar operaciones sobre la entidad Club */
    @Autowired
    private ClubRepository clubRepository;
    /**
     * Obtiene la lista completa de clubes.
     * 
     * @return una lista de todos los clubes en la base de datos.
     */
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
    /**
     * Obtiene un club específico por su ID.
     * 
     * @param id el ID del club a buscar.
     * @return un Optional que contiene el club si se encuentra, o vacío si no.
     */
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }
    /**
     * Crea un nuevo club en la base de datos.
     * 
     * @param club el objeto Club a crear.
     * @return el club creado.
     */
    public Club createClub(Club club) {
        return clubRepository.save(club);
    }
    /**
     * Actualiza un club existente.
     * 
     * @param id el ID del club a actualizar.
     * @param clubDetails el objeto Club con los nuevos detalles.
     * @return el club actualizado.
     * @throws RuntimeException si el club no se encuentra.
     */
    public Club updateClub(Long id, Club clubDetails) {
    	 // Busca el club por ID, lanza excepción si no se encuentra
        Club club = clubRepository.findById(id).orElseThrow(() -> new RuntimeException("Club no encontrado"));
        // Actualiza los detalles del club
        club.setNombreClub(clubDetails.getNombreClub());
        club.setMailClub(clubDetails.getMailClub());
        club.setContrasenyaClub(clubDetails.getContrasenyaClub());
        club.setColoresClub(clubDetails.getColoresClub());
        club.setDescripcionClub(clubDetails.getDescripcionClub());
        club.setLocalizadorClub(clubDetails.getLocalizadorClub());
        club.setFechaAltaClub(clubDetails.getFechaAltaClub());
        return clubRepository.save(club);
    }
    /**
     * Elimina un club específico.
     * 
     * @param id el ID del club a eliminar.
     */
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }
}

