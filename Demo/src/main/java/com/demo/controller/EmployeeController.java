package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import javax.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Save operation
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee emp = null;
		try {
			emp = employeeService.saveEmployee(employee);
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Read operation
	@GetMapping("/getEmployeeList")
	public ResponseEntity<List<Employee>> getEmployeeList() {
		try {
			return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update operation
	@PutMapping("/employee/{id}/{bId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long empId) {
		Employee emp = null;
		try {
			emp = employeeService.updateEmployee(employee, empId);
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete operation
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long empId) {
		employeeService.deleteEmployeeById(empId);
		return "Deleted Successfully";
	}

}
