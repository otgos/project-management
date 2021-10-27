package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String displayEmployee(Model model){
        List<Employee> anEmployees = empRepo.findAll();
        model.addAttribute("employees", anEmployees);
        return "employees/list-employees";
    }

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }
    @PostMapping("/save")
    public String createEmployeeForm(Employee employee, Model model){
        empRepo.save(employee);

        return "redirect:/employees/new";
    }


}
