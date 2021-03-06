package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EnployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EnployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl (EnployeeRepository theEmployeeDao){
		employeeRepository = theEmployeeDao;
	}
	
	@Override	
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override	
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result != null)
		{
			theEmployee = result.get();
		}
		
		return theEmployee;
	}

	@Override	
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int Id) {
		employeeRepository.deleteById(Id);

	}

}
