package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both Customer and Employee Entities.
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PetService petService;

	@PostMapping("/customer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
		Customer customer = convertDTOToCustomer(customerDTO);
		return convertCustomerToDTO(userService.saveCustomer(customer));
	}

	@GetMapping("/customer")
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = userService.getCustomers();

		List<CustomerDTO> customerDTOs = customers.stream().map(customer -> convertCustomerToDTO(customer))
				.collect(Collectors.toList());

		return customerDTOs;
	}

	@GetMapping("/customer/pet/{petId}")
	public CustomerDTO getOwnerByPet(@PathVariable long petId) {
		return convertCustomerToDTO(userService.getCustomerByPet(petId));
	}

	@PostMapping("/employee")
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Employee employee = convertDTOToEmployee(employeeDTO);
		return convertEmployeeToDTO(userService.saveEmployee(employee));
	}

	@PostMapping("/employee/{employeeId}")
	public EmployeeDTO getEmployee(@PathVariable long employeeId) {
		return convertEmployeeToDTO(userService.getEmployee(employeeId));
	}

	@PutMapping("/employee/{employeeId}")
	public EmployeeDTO setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
		return convertEmployeeToDTO(userService.setEmployeeAvailability(daysAvailable, employeeId));
	}

	@GetMapping("/employee/availability")
	public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
		List<Employee> availableEmployees = userService.findEmployeesForService(employeeDTO);

		List<EmployeeDTO> employeeDTOs = availableEmployees.stream().map(employee -> convertEmployeeToDTO(employee))
				.collect(Collectors.toList());

		return employeeDTOs;
	}

	// Helper methods

	// <--- Customer --->
	private CustomerDTO convertCustomerToDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);

		// Retrieve Pet's identifiers from Pet entities
		List<Pet> pets = customer.getPets();

		if (pets != null) {
			List<Long> petIds = pets.stream().map(pet -> pet.getId()).collect(Collectors.toList());

			customerDTO.setPetIds(petIds);

		}

		return customerDTO;
	}

	public Customer convertDTOToCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);

		// Retrieve Pet's identifiers to get Pet entities
		List<Long> petIds = customerDTO.getPetIds();

		if (petIds != null) {
			List<Pet> pets = petService.getPetsByIds(petIds);
			customer.setPets(pets);
		}

		return customer;
	}

	// <--- Employee --->
	private EmployeeDTO convertEmployeeToDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);

		employeeDTO.setDaysAvailable(employee.getWorkDays());

		return employeeDTO;
	}

	public Employee convertDTOToEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);

		employee.setWorkDays(employeeDTO.getDaysAvailable());

		return employee;
	}
}
