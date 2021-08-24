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
import java.util.logging.Logger;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeDao employeeDao;

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeImp> employee = employeeDao.findEmployeeImpByUsername(username);
        logger.warning(employee.get().getRoles());
        employee.orElseThrow(()-> new UsernameNotFoundException("Not Found: " + username));
        return employee.map(MyUserDetails::new).get();
    }
}
