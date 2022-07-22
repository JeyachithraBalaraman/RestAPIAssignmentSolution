package com.gl.employee.service;

import java.util.List;

import com.gl.employee.entity.Employee;
import com.gl.employee.entity.Role;
import com.gl.employee.entity.User;

import org.springframework.data.domain.Sort.Direction;

public interface EmployeeService {

	
	public void saveUser(User user);
	public void saveRole(Role role);
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	
    public List<Employee> findAll();
	public Employee findById(int theId);
	public List<Employee> searchByFirstName(String firstName);
	public List<Employee> sortByFirstNameAsc();
	public List<Employee> findAllCustomSorted(Direction direction);
}
