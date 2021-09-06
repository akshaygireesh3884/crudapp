//package com.example.crudapplication;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//class CrudapplicationApplicationTests {
//    @Autowired
//    private TestRestTemplate restTemplate;
//    @LocalServerPort
//    private int port;
//
//    private String getRootUrl() {
//        return "http://localhost:" + port;
//    }
//
//    @Test
//    void contextLoads() {
//    }
//    @Test
//    public void testGetAllEmployees() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
//                HttpMethod.GET, entity, String.class);
//
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testGetEmployeeById() {
//        Employee employee = restTemplate.getForObject(getRootUrl() + "/employees/1", Employee.class);
//        System.out.println(employee.getFirstName());
//        assertNotNull(employee);
//    }
//
//}
