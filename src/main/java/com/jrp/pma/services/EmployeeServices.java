package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {


    //Field Injection
    @Autowired
    EmployeeRepository empRepo;

    //Constructor Injector
//    public EmployeeServices(EmployeeRepository empRepo) {
//        this.empRepo = empRepo;
//    }

    //Setter Injector
    @Autowired
    public void setEmpRepo(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }
}
