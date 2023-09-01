package com.revisionone.Employee.Service;

import com.revisionone.Employee.Entity.EmployeeEntity;
import com.revisionone.Employee.Model.EmployeeRequest;
import com.revisionone.Employee.Model.EmployeeResponse;
import com.revisionone.Employee.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository empRep;
    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest empReq) {
        EmployeeEntity empEnt = new EmployeeEntity();
        BeanUtils.copyProperties(empReq, empEnt);
        empRep.save(empEnt);
        EmployeeResponse empRes = EmployeeResponse.builder()
                .empId(empReq.getEmpId())
                .empName(empReq.getEmpName())
                .empLocation(empReq.getEmpLocation())
                .build();
        return empRes;
    }
}
