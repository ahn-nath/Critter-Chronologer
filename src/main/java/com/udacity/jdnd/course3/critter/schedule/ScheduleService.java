package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeRepository;

@Service
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

	
	public List<Schedule> getSchedulesForCustomer(long id) {
		//return scheduleRepository.findByCustomers(id);
		/**
		 * Get Pet schedules for each pet of the customer
		 * add them to customerSchedules list
		 * */
		
		
		return null;
	}
	

	public List<Schedule> getSchedulesForEmployee(long id) {
		return scheduleRepository.findByEmployees(employeeRepository.getOne(id));
	}

	public List<Schedule> getSchedulesForPet(long id) {
		return scheduleRepository.findByPets(petRepository.getOne(id));
	}

}
