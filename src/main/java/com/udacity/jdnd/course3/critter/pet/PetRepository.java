package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Specifies methods used to obtain and modify pet related information which is
 * stored in the database.
 */

@Repository
@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {

	// returns all the pets of specific owner
	List<Pet> findAllByCustomerId(Long id);

}
