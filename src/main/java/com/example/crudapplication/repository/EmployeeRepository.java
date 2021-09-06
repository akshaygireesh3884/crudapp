package com.example.crudapplication.repository;

import com.example.crudapplication.entity.Employee;
import org.springframework.data.repository.CrudRepository;



public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}