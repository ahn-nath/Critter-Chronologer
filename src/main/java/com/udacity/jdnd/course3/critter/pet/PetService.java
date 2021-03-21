package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;

	public Long savePet(Pet pet) {
		return petRepository.save(pet).getId();
	}
	
	public Pet getPet(long id) {
		return petRepository.getOne(id);
	}
	
	public List<Pet> getPets() {
		return petRepository.findAll();
	}
	
	public List<Pet> getPetsByOwner(long ownerId) {
		return petRepository.findByCustomer(ownerId);
	}	

}
