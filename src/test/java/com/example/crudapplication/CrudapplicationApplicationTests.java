package com.example.crudapplication;



import com.example.crudapplication.entity.Employee;
import com.example.crudapplication.repository.EmployeeRepository;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

@SpringBootTest
class CrudapplicationApplicationTests {

    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/employeeserv/employees",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = restTemplate.getForObject(getRootUrl() + "/api/v1/employeeserv/employees/7", Employee.class);
        assertNotNull(employee);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Akhil");
        employee.setLastName("mm");
        employee.setRole("tester");
        employee.setDesignation("SE");
        employee.setSalary(10000);
        Date date = new Date();
        employee.setDoj(date);
        employee.setAddress("Chennai");
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/employeeserv/employees", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Employee employee = restTemplate.getForObject(getRootUrl() + "/api/v1/employeeserv/employees/" + id, Employee.class);
        employee.setRole("TESTER");
        employee.setDesignation("ASE");
        employee.setAddress("Kerala");

        restTemplate.put(getRootUrl() + "/api/v1/employeeserv/employees/" + id, employee);

        Employee updatedEmployee = restTemplate.getForObject(getRootUrl() + "/api/v1/employeeserv/employees/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 7;
        Employee employee = restTemplate.getForObject(getRootUrl() + "/api/v1/employeeserv/employees/" + id, Employee.class);
        assertNotNull(employee);

        restTemplate.delete(getRootUrl() + "/api/v1/employeeserv/employees/" + id);

        try {
            employee = restTemplate.getForObject(getRootUrl() + "/api/v1/employeeserv/employees/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}