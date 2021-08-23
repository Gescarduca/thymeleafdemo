package com.malsum.thymeleafdemo.services;


import com.malsum.thymeleafdemo.dao.EmployeeDao;
import com.malsum.thymeleafdemo.model.Employee;
import com.malsum.thymeleafdemo.model.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeImp> findAllEmployees(String keyword) {
        if (keyword!=null){
            return employeeDao.findAllByName(keyword).stream().collect(Collectors.toUnmodifiableList());
        }
        //streamsupport is needed to use spliterator
        return StreamSupport.stream(employeeDao.findAllByOrderByLastNameAsc().spliterator(),false).collect(Collectors.toUnmodifiableList());
    }
//    @Override
//    public List<EmployeeImp> findAllEmployees() {
//        //streamsupport is needed to use spliterator
//        return StreamSupport.stream(employeeDao.findAllByOrderByLastNameAsc().spliterator(),false).collect(Collectors.toUnmodifiableList());
//    }


    @Override
    public EmployeeImp findById(int id) {
        Optional<EmployeeImp> optional = employeeDao.findById(id);
        return optional.orElse(null);
    }


    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void save(EmployeeImp employeeImp) {
        employeeDao.save(employeeImp);
    }


}
