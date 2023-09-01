package com.revisionone.Employee.Controller;

import com.revisionone.Employee.Model.EmployeeRequest;
import com.revisionone.Employee.Model.EmployeeResponse;
import com.revisionone.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empSer;
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest empReq){
        EmployeeResponse empRes = empSer.saveEmployee(empReq);
        return new ResponseEntity<>(empRes, HttpStatus.CREATED);
    }
}
