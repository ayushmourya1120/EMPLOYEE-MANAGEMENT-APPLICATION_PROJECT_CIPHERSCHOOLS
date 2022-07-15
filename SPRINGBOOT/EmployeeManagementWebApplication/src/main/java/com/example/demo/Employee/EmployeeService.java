package com.example.demo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Employee> employees = new ArrayList<>( Arrays.asList(
			new Employee("101","James Smith","DEVELOPMENT"),
			new Employee("102","Jane Karloskar","SALES"),
			new Employee("103","Tim Buchalka","H.R.")
			));
	
	
	public List<Employee> getAllEmployees(){
		
		ArrayList<Employee> employeesarr = new ArrayList<>();
		
		employeeRepository.findAll()
		.forEach(employeesarr::add);
		
		return employeesarr;
	}


	public Optional<Employee> getEmployee(String id) {
		
		return employeeRepository.findById(id);
	}
	
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}


	public void updateEmployee(Employee emp, String id) {
		employeeRepository.save(emp);
	}


	public void deleteEmployee(String id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
