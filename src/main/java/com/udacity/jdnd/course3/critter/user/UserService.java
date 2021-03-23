package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PetRepository petRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByPet(long id) {
		Pet pet = petRepository.getOne(id);
		
		return customerRepository.findByPets(pet);
	}
	
	public Customer getCustomer(long ownerId) {
		return customerRepository.getOne(ownerId);
	}
	  
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployee(long id) {
		return employeeRepository.getOne(id);
	}

	
	public void setEmployeeAvailability(Set<DayOfWeek> days, long id) {
		Employee employeeToUpdate = employeeRepository.getOne(id);
		
		employeeToUpdate.setWorkDays(days);
		employeeRepository.save(employeeToUpdate);
	}


	/*
	public List<Employee> findEmployeesForService() {
		return employeeRepository.findEmployeeByService();
	}
	
	*/
	
	

}
