package com.dev.Employee.Management.controller;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Employee.Management.entity.EmployeeEntity;
import com.dev.Employee.Management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		//super();
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List findAllEmployee()
	{
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/(id)")
	public java.util.Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id)
	{
		return employeeService.findById(id);
	}
	@PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity, null);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public EmployeeEntity saveEmpResponse(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping("/res/{id}")
    public EmployeeEntity updateEmpResponse(@RequestBody EmployeeEntity employeeEntity, @PathVariable("id") Long id) {
        return employeeService.updateEmployee(employeeEntity, id);
    }
	
}
