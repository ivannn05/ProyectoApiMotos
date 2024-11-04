package edu.jsia.api.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsia.api.servicios.*;

/**
 * Define una interfaz de repositorio en Spring Data JPA para gestionar las
 * operaciones con la entidad club.
 * 
 */
public interface ClubRepository extends JpaRepository<Club, Long> {
	Club findByMailClub(String mailClub);
}
