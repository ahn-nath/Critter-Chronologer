package com.udacity.jdnd.course3.critter.pet;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {

	// returns all the pets of specific owner
	List<Pet> findByCustomer(Long id);
	
}
