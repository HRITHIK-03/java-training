package com.dev.Employee.Management.service.impl;

import java.util.Optional;

import org.apache.tomcat.util.digester.ServiceBindingPropertySource;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.dev.Employee.Management.entity.EmployeeEntity;
import com.dev.Employee.Management.repository.EmployeeRepository;
import com.dev.Employee.Management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository; 
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public List findAllEmployee() {
		// TODO Auto-generated method stub
		return (List) employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeEntity> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeEntity);
	}

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
