package com.malsum.thymeleafdemo.SecurityDetails;

import com.malsum.thymeleafdemo.dao.EmployeeDao;
import com.malsum.thymeleafdemo.model.Employee;
import com.malsum.thymeleafdemo.model.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeImp> employee = employeeDao.findEmployeeImpByUsername(username);
        employee.orElseThrow(()-> new UsernameNotFoundException("Not Found: " + username));
        return employee.map(MyUserDetails::new).get();
    }
}
