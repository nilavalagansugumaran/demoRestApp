package com.example.demoRestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController // ("/employee") - root path
@CrossOrigin
public class EmployeeController {

    @Autowired private EmployeeService service;

    @GetMapping(path = "/oneEmployee", headers = "Accept=application/json, application/xml")
    //@RequestMapping
    public Employee getOneEmployee() {

        return new Employee(101L, "nila-101", 1000.d);
    }

    @GetMapping(path = "/employee/{id}", headers = "Accept=application/json, application/xml")
    public Employee getEmployee(@PathVariable("id") Long id) {

       Employee e =  service.getEmployee(id);

       if (e == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for id " + id);
       }
       return e;
    }

}
