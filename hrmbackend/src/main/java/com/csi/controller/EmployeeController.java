package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/employees/")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        log.info("#######TRYING TO SAVE DATA for Employee : "+employee.getEmpFirstName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/{empId}")
    public Employee getDataById(@PathVariable int empId){
        return employeeServiceImpl.getDataById(empId);
    }


    @GetMapping("/")
    public List<Employee> getAllData(){
        return employeeServiceImpl.getAllData();
    }

    @PutMapping("/{empId}")
    public Employee updateData(@PathVariable int empId, @RequestBody Employee employee) throws RecordNotFoundException {
        //
        Employee employee1= employeeRepository.findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Data Not Found"));

        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        return employeeServiceImpl.updateData(employee1);
    }

    @DeleteMapping("/{empId}")
    public String deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return "Data Deleted Successfully";
    }
}
