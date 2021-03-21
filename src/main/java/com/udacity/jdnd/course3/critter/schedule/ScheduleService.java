package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public List<Schedule> getSchedules() {
		return scheduleRepository.findAll();
	}
	
	/*
	public List<Schedule> getSchedulesForCustomer(long id) {
		return scheduleRepository.findByCustomers(id);
	}
	*/
	
	public List<Schedule> getSchedulesForEmployee(long id) {
		return scheduleRepository.findByEmployees(id);
	}
	
	public List<Schedule> getSchedulesForPet(long id) {
		return scheduleRepository.findByPets(id);
	}

}
