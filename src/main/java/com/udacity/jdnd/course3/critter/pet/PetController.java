package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 * 
 * Includes requests for both Customer and Pet Entities. 
 *  
 */
@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private UserService userService;

	/***
	 * If a POST request is received, convert PetDTO to a Pet Entity 
	 * to save in the database, return the 'row' added as a DTO 
	 ***/
	
	@PostMapping
	public PetDTO savePet(@RequestBody PetDTO petDTO) {	
			
			Customer customer = userService.getCustomer(petDTO.getOwnerId());
			System.out.println("owener" + petDTO.getOwnerId());
			
			Pet pet = convertDTOToPet(petDTO);
			pet.setCustomer(customer);
			return convertPetToDTO(petService.savePet(pet));
		
		
		// add exception for customer does not exist (id)
	}

	
	/***
	 * If a GET request with a petId as parameter is received, get Pet, convert it
	 * to a PetDTO and return it
	 ***/
	@GetMapping("/{petId}")
	public PetDTO getPet(@PathVariable long petId) {
		return convertPetToDTO(petService.getPet(petId));
	}

	
	/***
	 * If a GET request is received, get all Pets, 
	 * convert them to PetDTO and return list 
	 ***/
	@GetMapping
	public List<PetDTO> getPets() {
		
		List<Pet> pets = petService.getPets();
		List<PetDTO> petDTOs = pets.stream()
				.map(pet -> convertPetToDTO(pet))
				.collect(Collectors.toList());
		
		
		return petDTOs;
	}

	/***
	 * If a GET request is received with the owner id, get all Pets associated to that owner, 
	 * convert them to PetDTO and return list 
	 ***/
	@GetMapping("/owner/{ownerId}")
	public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
		List<Pet> pets = petService.getPetsByOwner(ownerId);
		List<PetDTO> petDTOs = pets.stream()
				.map(pet -> convertPetToDTO(pet))
				.collect(Collectors.toList());
		
		
		return petDTOs;
	}

	
	// Helper methods
	private PetDTO convertPetToDTO(Pet pet) {
		PetDTO petDTO = new PetDTO();
		BeanUtils.copyProperties(pet, petDTO);
		
		// the Pet doesn't automatically sets the customer id from the Customer entity
		petDTO.setOwnerId(pet.getCustomer().getId());
		
		return petDTO;
	}
	
	public Pet convertDTOToPet(PetDTO petDTO){
	    Pet pet = new Pet();
	    BeanUtils.copyProperties(petDTO, pet);
	    return pet;
	  }
}
