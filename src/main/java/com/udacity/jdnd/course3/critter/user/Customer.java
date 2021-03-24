package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

import com.udacity.jdnd.course3.critter.pet.Pet;

import java.util.ArrayList;

@Entity
public class Customer extends Users {

	@Nationalized
	private String notes;

	@OneToMany(mappedBy = "customer") // a customer can have many pets
	private List<Pet> pets = new ArrayList<Pet>();

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

}
