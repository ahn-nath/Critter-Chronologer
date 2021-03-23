package com.udacity.jdnd.course3.critter.pet;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.Customer;

@Entity
@Table(name = "pet")
public class Pet {

	@Column(name = "type_code")
	@Enumerated(EnumType.STRING)
	private PetType type;

	@Id
	@GeneratedValue
	private long id;

	@Nationalized
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToMany(mappedBy = "pets")
	private List<Schedule> schedules;

	private LocalDate birthDate;

	@Nationalized
	private String notes;

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;

	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
