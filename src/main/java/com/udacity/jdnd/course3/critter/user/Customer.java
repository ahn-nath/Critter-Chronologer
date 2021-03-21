package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

import com.udacity.jdnd.course3.critter.pet.Pet;

@Entity
public class Customer extends User {

	@Nationalized
	private String notes;

	@OneToMany(mappedBy = "customer") // a customer can have many pets
	private List<Pet> pets;



	public String getNotes() {
		return notes;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
