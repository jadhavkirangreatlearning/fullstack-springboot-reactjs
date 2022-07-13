package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaompl {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveData(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getDataById(int empId){
        return employeeRepository.findById(empId).get();
    }

    public List<Employee> getAllData(){
        return employeeRepository.findAll();
    }

    public Employee updateData(Employee employee){
        return employeeRepository.save(employee);


    }

    public void deleteDataById(int empId){
        employeeRepository.deleteById(empId);
    }


}
