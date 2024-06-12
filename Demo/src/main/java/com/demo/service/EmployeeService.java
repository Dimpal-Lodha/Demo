package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {
	
	 // Save operation
    Employee saveEmployee(Employee employee);
 
    // Read operation
    List<Employee> getEmployeeList();
 
    // Update operation
    Employee updateEmployee(Employee employee,
                                Long empId);
 
    // Delete operation
    void deleteEmployeeById(Long empId);

}
