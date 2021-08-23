package com.malsum.thymeleafdemo.services;

import com.malsum.thymeleafdemo.model.EmployeeImp;
import org.springframework.stereotype.Service;

import java.util.List;



public interface EmployeeService {

    public List<EmployeeImp> findAllEmployees(String keyword);
    //public List<EmployeeImp> findAllEmployees();

    public EmployeeImp findById(int id);

//    public EmployeeImp updateEmployee(EmployeeImp employee);//hibernate does this thing that it checks if the employee exists(based on id) and if it already does it updates
//    //the object if it does not it creates a new employee

    public void deleteById(int id);

    public void save(EmployeeImp employeeImp);

}
