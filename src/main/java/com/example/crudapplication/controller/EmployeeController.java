package com.example.crudapplication.controller;


import com.example.crudapplication.entity.Employee;
import com.example.crudapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/v1/employeeserv/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveUser(employee);
    }

    @GetMapping("/v1/employeeserv/employees")
    public List<Employee> findAllEmployees() {
        return service.getUsers();
    }

    @GetMapping("/v1/employeeserv/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PutMapping("/v1/employeeserv/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateUser(employee);
    }

    @DeleteMapping("/v1/employeeserv/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteUser(id);
    }
}

