package com.malsum.thymeleafdemo.controller;

import com.malsum.thymeleafdemo.model.Employee;
import com.malsum.thymeleafdemo.model.EmployeeImp;
import com.malsum.thymeleafdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //private logger
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private EmployeeService employeeService;

    @Autowired//constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    //add mapping for /list
//@Param("keyword") String keyword
    @GetMapping("/list")
    public String listEmployees(Model model,String keyword){
        List<EmployeeImp>  theEmployees = employeeService.findAllEmployees(keyword);
        //List<EmployeeImp>  theEmployees = employeeService.findAllEmployees();
        for (EmployeeImp e: theEmployees){
            logger.info(e.toString());
        }
        model.addAttribute("employees", theEmployees);//thymeleaf template uses this string as variable to acess
        model.addAttribute("keyword",keyword);
        return "employees/list-employees";//by deafult spring searches the templates directory but if you create new folder you must specify the path
    }


    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){
        //create model attribute to bind form data
        EmployeeImp employee = new EmployeeImp();
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    //@modelatribute cause employee model comes from the employee form above
    //in the html is  th:object"${employee} that is passed here
    public String saveEmployee(@ModelAttribute("employee") EmployeeImp employee){
        //save the employee`
        employeeService.save(employee);

        //use a redirect to prevent duplications
        return "redirect:/employees/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        //get employee
        //set employee as a model attribute
        //send the form with prepopulated info
        EmployeeImp employee = employeeService.findById(id);
          model.addAttribute("employee",employee);
          return "employees/employee-form";
    }

    @GetMapping("/delete")//when building spring mvc based apps we can only use get and post method, only on rest applications can we use all HTTP methods
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}



//    //load emplyee data
//    private Collection<EmployeeImp> theEmployees;
//
//    @PostConstruct
//    private void loadData(){
//        theEmployees = new ArrayList<>();
//        theEmployees.add(new EmployeeImp(1,"Leslie"," Andrews"," leslie@thymeleafattempt.com"));
//        theEmployees.add(new EmployeeImp(2,"Emma"," Bartowski"," emma@thymeleafattempt.com"));
//        theEmployees.add(new EmployeeImp(3,"Tony"," Andrews"," Tony@thymeleafattempt.com"));
//
//
//
//    }