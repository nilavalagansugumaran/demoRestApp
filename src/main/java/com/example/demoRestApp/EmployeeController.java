package com.example.demoRestApp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ("/employee") - root path
@CrossOrigin
public class EmployeeController {



    @GetMapping(path = "/oneEmployee", headers = "Accept=application/json, application/xml")
    //@RequestMapping
    public Employee getOneEmployee() {

        return new Employee(101L, "nila-101", 1000.d);
    }

}
