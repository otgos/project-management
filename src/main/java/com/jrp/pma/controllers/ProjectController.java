package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping
    public String displayProjects(Model model){
        List<Project> aProject = proRepo.findAll();
        model.addAttribute("projects", aProject);
        return "projects/list-projects";
    }


    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";

    }


    @PostMapping("/save")
    public String createProjectForm(Project project,  Model model){


        //this should handle saving to database
        //this is to attach projects to saved employee
        proRepo.save(project);

        return "redirect:/projects";

    }

}
