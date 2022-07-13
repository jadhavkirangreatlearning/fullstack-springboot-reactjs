package com.csi.service;

import com.csi.dao.EmployeeDaompl;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {



        @Autowired
        EmployeeDaompl employeeDaompl;

        public Employee saveData(Employee employee){
        return employeeDaompl.saveData(employee);
    }

        public Employee getDataById(int empId){
        return employeeDaompl.getDataById(empId);
    }

        public List<Employee> getAllData(){
        return employeeDaompl.getAllData();
    }

        public Employee updateData(Employee employee){
        return employeeDaompl.updateData(employee);


    }

        public void deleteDataById(int empId){
            employeeDaompl.deleteDataById(empId);
    }



}
