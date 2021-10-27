package com.jrp.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectStage;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    //to specify version of the app
    @Value("${version}")
    private String ver;

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        //to spedify version of the app
        model.addAttribute("versionNumber", ver);

        Map<String, Object> map = new HashMap<>();
       List<Project> projects = proRepo.findAll();
       model.addAttribute("projectList", projects);


       List<ProjectStage> projectData =  proRepo.getProjectStatus();
       //convert dataObject to Jason obj for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jasonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCnt", jasonString);

       List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
       model.addAttribute("employeeListProjectsCnt", employeesProjectCnt);

       return "main/home";
    }
}
