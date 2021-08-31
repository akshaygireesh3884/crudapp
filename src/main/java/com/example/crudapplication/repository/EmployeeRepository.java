package com.example.crudapplication.repository;

import com.example.crudapplication.entity.Employee;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//    User findByName(String firstName);
//    User findByName(String lastName);
}