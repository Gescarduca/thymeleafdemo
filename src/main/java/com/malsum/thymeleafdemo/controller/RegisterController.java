package com.malsum.thymeleafdemo.controller;

import com.malsum.thymeleafdemo.model.EmployeeImp;
import com.malsum.thymeleafdemo.services.EmployeeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model){
        EmployeeImp employee = new EmployeeImp();
        model.addAttribute("employee",employee);
        return "registration-form";
    }

    @PostMapping("/registerEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeImp employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "registration-form";
        }
        employeeService.save(employee);
        return "redirect:/showLoginPage";
    }
}
