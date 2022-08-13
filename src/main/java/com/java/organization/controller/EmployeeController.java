package com.java.organization.controller;

import com.java.organization.dto.EmployeeRequest;
import com.java.organization.dto.RestResponse;
import com.java.organization.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
private EmployeeService employeeService;

    @PostMapping(path ="/create")
    public ResponseEntity<RestResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);

    }
    @GetMapping(path ="/find")
    public ResponseEntity<RestResponse> findEmployeesByOrganizationId(@RequestParam(name = "organizationId") int organizationId){
        return null;
    }
}