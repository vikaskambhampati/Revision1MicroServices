package com.revisionone.Employee.Controller;

import com.revisionone.Employee.Model.EmployeeRequest;
import com.revisionone.Employee.Model.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest empReq){
        EmployeeResponse empRes = EmployeeResponse.builder()
                .empId(empReq.getEmpId())
                .empName(empReq.getEmpName())
                .empLocation(empReq.getEmpLocation())
                .build();
        return new ResponseEntity<>(empRes, HttpStatus.CREATED);
    }
}
