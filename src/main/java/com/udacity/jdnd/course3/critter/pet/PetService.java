package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;

@Service
@Transactional
public class PetService {

	@Autowired
	PetRepository petRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public Pet savePet(Pet pet) {
		Pet persistedPet = petRepository.save(pet); // persist data

		Customer customer = persistedPet.getCustomer(); // get Customer
		customer.addPet(persistedPet); // update pets associated
		customerRepository.save(customer); // update database

		return persistedPet;
	}

	public Pet getPet(long id) {
		return petRepository.getOne(id);
	}

	public List<Pet> getPets() {
		return petRepository.findAll();
	}

	public List<Pet> getPetsByOwner(long ownerId) {
		return petRepository.findAllByCustomerId(ownerId);
	}

	public List<Pet> getPetsByIds(List<Long> petIds) {
		return petRepository.findAllById(petIds);
	}

}
