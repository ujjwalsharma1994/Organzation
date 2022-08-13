package com.java.organization.service;

import com.java.organization.dto.EmployeeRequest;
import com.java.organization.dto.RestResponse;
import com.java.organization.model.Employee;
import com.java.organization.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<RestResponse> createEmployee(EmployeeRequest employeeRequest) {

        if (employeeRequest != null) {
            if (employeeRequest.getEmployeeId() != 0) {
                Employee emp = new Employee(employeeRequest.getEmployeeId(), employeeRequest.getEmployeeName(),
                        employeeRequest.getOrganizationId(),
                        employeeRequest.getSalary(), employeeRequest.getJobProfile(), employeeRequest.isManager(),
                        employeeRequest.getReportingManagerName(), employeeRequest.getEmailId());
                employeeRepository.save(emp);
                return ResponseEntity.status(201).body(new RestResponse(201, null, "Employee created successfully", emp));
            } else
                return ResponseEntity.status(400).body(new RestResponse(400, "Invalid Employee Id", null, null));
        } else
            return ResponseEntity.status(400).body(new RestResponse(400, "Invalid Request", null, null));

    }
}
