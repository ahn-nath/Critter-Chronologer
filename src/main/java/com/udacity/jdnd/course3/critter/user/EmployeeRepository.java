package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findAllByWorkDaysAndSkillsIn(DayOfWeek dayOfWeek, Set<EmployeeSkill> skills);

}
