package com.example.crudapplication.service;


import com.example.crudapplication.entity.Employee;
import com.example.crudapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed !! " + id;
    }

    public Employee updateEmployee(int id,Employee employee) {
        Employee existingEmployee = repository.findById(id).orElse(null);
        assert existingEmployee != null;
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setAddress(employee.getAddress());
        return repository.save(existingEmployee);
    }


}
