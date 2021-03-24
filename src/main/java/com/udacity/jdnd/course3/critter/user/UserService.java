package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return customerRepository.findByPets(petRepository.getOne(id));
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

	public Employee setEmployeeAvailability(Set<DayOfWeek> days, long id) {
		Employee employeeToUpdate = employeeRepository.getOne(id);
		employeeToUpdate.setWorkDays(days);

		return employeeRepository.save(employeeToUpdate);
	}

	public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeRequest) {
		Set<EmployeeSkill> skills = employeeRequest.getSkills();
		LocalDate date = employeeRequest.getDate();

		// filter to only get the employees that have ALL the required skills and not just one
		List<Employee> matchedEmployees = employeeRepository.findAllByWorkDaysAndSkillsIn(date.getDayOfWeek(), skills)
				.stream()
				.map(employee -> employee)
				.filter(employee -> employee.getSkills().containsAll(skills))
				.collect(Collectors.toList());
		
		return  matchedEmployees;
	}

	public List<Employee> getEmployeesByIds(List<Long> employeeIds) {
		return employeeRepository.findAllById(employeeIds);
	}

}
