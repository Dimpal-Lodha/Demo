package com.demo.serviceImp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Branch;
import com.demo.model.Employee;
import com.demo.repository.BranchRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
    private BranchRepository branchRepository;
 
    // Save operation
    public Employee saveEmployee(Employee employee)
    
    {
    	Branch branch = branchRepository.findById(employee.getBranchId()).get();
    	employee.setBranch(branch);
        return employeeRepository.save(employee);
    }
 
    // Read operation
    public List<Employee> getEmployeeList() {
    	List<Employee> emp = null;
    	try {
    		emp = employeeRepository.findAll();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
        return emp;
        		
    }
 
    // Update operation
    
    public Employee updateEmployee(Employee employee,
            Long empId)
    {
    	Employee emp
            = employeeRepository.findById(empId)
                  .get();
 
        if (Objects.nonNull(employee.getFirstName())
            && !"".equalsIgnoreCase(
            		employee.getFirstName())) {
            emp.setFirstName(
            		employee.getFirstName());
        }
 
        if (Objects.nonNull(
        		employee.getLastName())
            && !"".equalsIgnoreCase(
            		employee.getLastName())) {
        	emp.setLastName(
        			employee.getLastName());
        }
 
        if (Objects.nonNull(employee.getSalary())) {
            emp.setSalary(
            		employee.getSalary());
        }
 
        if (Objects.nonNull(employee.getBranchId())) {
        	Branch branch = branchRepository.findById(employee.getBranchId()).get();
            emp.setBranch(
            		branch);
        }
        return employeeRepository.save(emp);
    }
 
    // Delete operation
    public void deleteEmployeeById(Long empId)
    {
    	employeeRepository.deleteById(empId);
    }

	
	
}
	
	


