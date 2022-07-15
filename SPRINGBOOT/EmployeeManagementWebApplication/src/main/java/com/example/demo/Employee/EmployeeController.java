package com.example.demo.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello From SpringBoot";
	}
	// Method to List All Employees
	// (List) Operation
	@RequestMapping("/employee")
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// let us define a method that fetches a particular given Employee by ID
	// (Search) Operation
	@RequestMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}
	
	//let us define a function that adds the employee into Employees List
	// (Add) Operation
	@RequestMapping(method = RequestMethod.POST,value="/employee")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
	}
	
	
	// This Function Contains the Logic to update the Employee Details.
	//(Update) Operation
	
	@RequestMapping(method=RequestMethod.PUT,value="/employee/{id}")
	public void updateEmployee(@RequestBody Employee emp ,@PathVariable String id) {
		
		employeeService.updateEmployee(emp,id);
	}
	
	
	// This Function Explains the Programming Logic to Delete the Employee Details
	// (Delete) Operation
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}
}
