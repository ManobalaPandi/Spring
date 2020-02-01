package com.switchcode.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.switchcode.springboot.thymeleafdemo.entity.Employee;

public interface EnployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
	
}
