package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	// returns all schedules by pet
	List<Schedule> findByPets(Long id); // check how this query works
	
	// returns all schedule by employee
	List<Schedule> findByEmployees(Long id); // check how this query works
	
	/*
	// returns all schedules by customer
	List<Schedule> findByCustomer(Long id);
	 */
}
