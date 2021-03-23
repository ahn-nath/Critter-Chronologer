package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
    	Schedule  schedule = convertDTOToSchedule(scheduleDTO);
		return convertScheduleToDTO(scheduleService.saveSchedule(schedule));
		
		//throw new UnsupportedOperationException();
    }


	@GetMapping
    public List<ScheduleDTO> getAllSchedules() {
		List<Schedule> schedules = scheduleService.getSchedules();
		List<ScheduleDTO> scheduleDTOs = schedules.stream()
				.map(schedule -> convertScheduleToDTO(schedule))
				.collect(Collectors.toList());
		
		return scheduleDTOs;
		
		//throw new UnsupportedOperationException();
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        throw new UnsupportedOperationException();
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
