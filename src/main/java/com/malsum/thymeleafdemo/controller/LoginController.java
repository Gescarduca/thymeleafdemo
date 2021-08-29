package com.malsum.thymeleafdemo.controller;


import com.malsum.thymeleafdemo.model.Employee;
import com.malsum.thymeleafdemo.model.EmployeeImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login-form";
    }

    // add request mapping for /access-denied

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "access-denied";
    }



}
