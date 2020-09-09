package com.gsa.consume.microservices.api;

import com.gsa.consume.microservices.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    public MyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getEmp")
    public List<Employee> getEmployee()
    {
        ParameterizedTypeReference<List<Employee>> param = new ParameterizedTypeReference<List<Employee>>() {
        };

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange("http://localhost:8090/getEmployee",HttpMethod.GET,
                null,param);
        return responseEntity.getBody();

    }

    @GetMapping("/getEmpMap")
    public Map<String,Employee> getEmpMap()
    {
        ParameterizedTypeReference<Map<String,Employee>> param = new ParameterizedTypeReference<Map<String, Employee>>() {
        };

        ResponseEntity<Map<String,Employee>> responseEntity = restTemplate.exchange("http://localhost:8090/getEmployeeMap",HttpMethod.GET,null,param);
        return responseEntity.getBody();

    }

    @PostMapping("/getEmpPost")
    public List<Employee> getEmployees() throws URISyntaxException {
        List<Employee> emp = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setDesignation("Software Engineer");
        e1.setEmployeeID("1234ABCD");
        e1.setEmployeeName("Raghav Sharma");
        e1.setSalary(30000f);
        e1.setReporttingManager("John Wick");

        Employee e2 = new Employee();
        e2.setDesignation("Software Engineer");
        e2.setEmployeeID("1235ABCD");
        e2.setEmployeeName("Sumit Sharma");
        e2.setSalary(40000f);
        e2.setReporttingManager("John Wick");

        Employee e3 = new Employee();
        e3.setDesignation("Associate Software Engineer");
        e3.setEmployeeID("1236ABCD");
        e3.setEmployeeName("Manish Pandey");
        e3.setSalary(20000f);
        e3.setReporttingManager("John Wick");

        Employee e4 = new Employee();
        e4.setDesignation("Senior Software Engineer");
        e4.setEmployeeID("1237ABCD");
        e4.setEmployeeName("Sumit Pradhan");
        e4.setSalary(80000f);
        e4.setReporttingManager("John Wick");

        emp.add(e1);
        emp.add(e2);
        emp.add(e3);
        emp.add(e4);

        RequestEntity<List<Employee>> requestEntity = RequestEntity.post(new URI("http://localhost:8090/getEmpPost"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(emp);

        ParameterizedTypeReference<List<Employee>> param = new ParameterizedTypeReference<List<Employee>>() {
        };

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(requestEntity,param);

        return responseEntity.getBody();
    }

    @PostMapping("/getEmpMapPost")
    public Map<String,Employee> getMapEmployeePost() throws URISyntaxException, IOException {
        Employee e1 = new Employee();
        e1.setDesignation("Software Engineer");
        e1.setEmployeeID("1234ABCD");
        e1.setEmployeeName("Raghav Sharma");
        e1.setSalary(30000f);
        e1.setReporttingManager("John Wick");

        Employee e2 = new Employee();
        e2.setDesignation("Software Engineer");
        e2.setEmployeeID("1235ABCD");
        e2.setEmployeeName("Sumit Sharma");
        e2.setSalary(40000f);
        e2.setReporttingManager("John Wick");

        Employee e3 = new Employee();
        e3.setDesignation("Associate Software Engineer");
        e3.setEmployeeID("1236ABCD");
        e3.setEmployeeName("Manish Pandey");
        e3.setSalary(20000f);
        e3.setReporttingManager("John Wick");

        Employee e4 = new Employee();
        e4.setDesignation("Senior Software Engineer");
        e4.setEmployeeID("1237ABCD");
        e4.setEmployeeName("Sumit Pradhan");
        e4.setSalary(80000f);
        e4.setReporttingManager("John Wick");

        Map<String,Employee> map = new HashMap<>();
        map.put("E1",e1);
        map.put("E2",e2);
        map.put("E3",e3);
        map.put("E4",e4);

        RequestEntity<Map<String,Employee>> requestEntity = RequestEntity.post(new URI("http://localhost:8090/getEmpMapPost"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);

        ParameterizedTypeReference<Map<String,Employee>> param = new ParameterizedTypeReference<Map<String, Employee>>() {
        };
        ResponseEntity<Map<String,Employee>> responseEntity = restTemplate.exchange(requestEntity,param);
        return responseEntity.getBody();

    }
}
