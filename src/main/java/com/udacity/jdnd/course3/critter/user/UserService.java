package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class UserService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByPet(long id) {
		return customerRepository.getCustomerByPets(id);
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
	
	/*
	public List<Employee> findEmployeesForService() {
		return employeeRepository.findEmployeeByService();
	}
	
	*/
	
	

}
