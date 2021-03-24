package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 * 
 * Includes requests for Schedule Entities.
 * 
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	/***
	 * If a POST request is received, convert ScheduleDTO to a Schedule Entity to
	 * save in the database, return the 'row' added as a DTO
	 ***/
	@PostMapping
	public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
		Schedule schedule = convertDTOToSchedule(scheduleDTO);
		return convertScheduleToDTO(scheduleService.saveSchedule(schedule));
	}

	/***
	 * If a GET request is received, get all Schedules as a List
	 ***/
	@GetMapping
	public List<ScheduleDTO> getAllSchedules() {
		List<Schedule> schedules = scheduleService.getSchedules();
		List<ScheduleDTO> scheduleDTOs = schedules.stream().map(schedule -> convertScheduleToDTO(schedule))
				.collect(Collectors.toList());

		return scheduleDTOs;

	}

	/***
	 * If a GET request with a Pet id is received, get Schedule for single Pet
	 ***/
	@GetMapping("/pet/{petId}")
	public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
		List<Schedule> schedules = scheduleService.getSchedulesForPet(petId);
		List<ScheduleDTO> scheduleDTOs = schedules.stream().map(schedule -> convertScheduleToDTO(schedule))
				.collect(Collectors.toList());

		return scheduleDTOs;
	}

	/***
	 * If a GET request with a Employee id is received, get Schedule for single
	 * Employee
	 ***/
	@GetMapping("/employee/{employeeId}")
	public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
		List<Schedule> schedules = scheduleService.getSchedulesForEmployee(employeeId);
		List<ScheduleDTO> scheduleDTOs = schedules.stream().map(schedule -> convertScheduleToDTO(schedule))
				.collect(Collectors.toList());

		return scheduleDTOs;
	}

	/***
	 * If a GET request with a Customer id is received, get Schedule for single
	 * Customer
	 ***/
	@GetMapping("/customer/{customerId}")
	public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
		List<Schedule> schedules = scheduleService.getSchedulesForCustomer(customerId);
		List<ScheduleDTO> scheduleDTOs = schedules.stream().map(schedule -> convertScheduleToDTO(schedule))
				.collect(Collectors.toList());

		return scheduleDTOs;
	}

	// Helper methods
	private Schedule convertDTOToSchedule(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		BeanUtils.copyProperties(scheduleDTO, schedule);

		return schedule;
	}

	private ScheduleDTO convertScheduleToDTO(Schedule schedule) {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		BeanUtils.copyProperties(schedule, scheduleDTO);

		return scheduleDTO;

	}

}
