package com.udacity.jdnd.course3.critter.schedule;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;

	@ManyToMany
	@JoinTable(name = "schedule_employee", 
	joinColumns = @JoinColumn(name = "schedule_id"), 
	inverseJoinColumns = @JoinColumn(name = "employee_id"))																																																										// later

	private List<Employee> employees;

	@ManyToMany
	private List<Pet> pets;

	private LocalDate date;

	@ElementCollection(targetClass = EmployeeSkill.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "ScheduleActivitiesTable", joinColumns = @JoinColumn(name = "scheduleId"))
	@Column(name = "activity")
	private Set<EmployeeSkill> activities = new HashSet<>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Set<EmployeeSkill> getActivities() {
		return activities;
	}

	public void setActivities(Set<EmployeeSkill> activities) {
		this.activities = activities;
	}

}
