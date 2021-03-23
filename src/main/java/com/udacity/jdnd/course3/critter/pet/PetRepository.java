package com.udacity.jdnd.course3.critter.pet;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Specifies methods used to obtain and modify pet related information
 * which is stored in the database.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

	// returns all the pets of specific owner
	List<Pet> findAllByCustomerId(Long id);
	
}
