package com.revisionone.Employee.Service;

import com.revisionone.Employee.Model.EmployeeRequest;
import com.revisionone.Employee.Model.EmployeeResponse;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeRequest empReq);
}
