package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	/*
	List<Employee> findEmployeeByServices();
	
	*/

}
