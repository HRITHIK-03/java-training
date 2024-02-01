package com.dev.Employee.Management.service;

import java.util.*;

import org.hibernate.mapping.List;

import com.dev.Employee.Management.entity.EmployeeEntity;

public interface EmployeeService{
	List findAllEmployee();
	Optional<EmployeeEntity> findById(long id);
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, Long id);
	void deleteEmployee(long id);
}
