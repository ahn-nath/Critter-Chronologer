package com.udacity.jdnd.course3.critter.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeRepository;

@Service
@Transactional
public class ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PetRepository petRepository;

	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	public List<Schedule> getSchedules() {
		return scheduleRepository.findAll();
	}

	/**
	 * Get Pet schedules for each pet of the customer add them to customerSchedules
	 * list
	 */
	public List<Schedule> getSchedulesForCustomer(long id) {

		List<Schedule> schedulesCustomer = new ArrayList<Schedule>();

		List<Pet> customerPets = customerRepository.getOne(id).getPets();

		for (Pet pet : customerPets) {
			schedulesCustomer.addAll(scheduleRepository.findByPets(pet));
		}

		return schedulesCustomer;
	}

	public List<Schedule> getSchedulesForEmployee(long id) {
		return scheduleRepository.findByEmployees(employeeRepository.getOne(id));
	}

	public List<Schedule> getSchedulesForPet(long id) {
		return scheduleRepository.findByPets(petRepository.getOne(id));
	}

}
