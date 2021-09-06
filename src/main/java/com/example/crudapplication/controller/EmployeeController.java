package com.example.crudapplication.controller;


import com.example.crudapplication.entity.Employee;
import com.example.crudapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/v1/employeeserv/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        try{
            return service.saveUser(employee);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw exception;
        }

    }

    @GetMapping("/v1/employeeserv/employees")
    public List<Employee> findAllEmployees() {
        try{
            return service.getUsers();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    @GetMapping("/v1/employeeserv/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) throws Exception {
        try {
            if(service.getUserById(id) != null)
                 return service.getUserById(id);
            throw  new Exception("Employee not Found");

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw  exception;
//            return Employee.Exception;
        }
    }


    @PutMapping("/v1/employeeserv/employees/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
        try{
            return service.updateUser(id,employee);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    @DeleteMapping("/v1/employeeserv/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        try{
            return service.deleteUser(id);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw exception;
        }

    }
}

