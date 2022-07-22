package com.gl.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employee.dao.EmployeeRepository;
import com.gl.employee.dao.RoleRepository;
import com.gl.employee.dao.UserRepository;
import com.gl.employee.entity.Employee;
import com.gl.employee.entity.Role;
import com.gl.employee.entity.User;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
    @Autowired
	BCryptPasswordEncoder bcryptEncoder;

	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
// POST operations	
	@Override
	public void saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}
//  DELETE operations	
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
// GET operations
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

	@Override
	public List<Employee> sortByFirstNameAsc() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}
	@Override
	public List<Employee> findAllCustomSorted(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction,"firstName"));
	}

}
