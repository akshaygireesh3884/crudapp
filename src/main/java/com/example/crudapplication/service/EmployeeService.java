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

    public Employee saveUser(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> saveUsers(List<Employee> employees) {
        return (List<Employee>) repository.saveAll(employees);
    }

    public List<Employee> getUsers() {
        return (List<Employee>) repository.findAll();
    }

    public Employee getUserById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }

    public Employee updateUser(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        assert existingEmployee != null;
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setAddress(employee.getAddress());
        return repository.save(existingEmployee);
    }


}
