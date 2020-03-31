package com.example.demoRestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController // ("/employee") - root path
@CrossOrigin
public class EmployeeController {

  //  @Autowired
  //  private EmployeeService service;

  //  @Autowired
   // private EmployeeJDBCService employeeJDBCService;

   // @Autowired EmployeeJPARepositoryService employeeJPARepositoryService;


    @Autowired EmployeeMongoRepositoryService employeeMongoRepositoryService;


    @GetMapping(path = "/oneEmployee", headers = "Accept=application/json, application/xml")
    //@RequestMapping
    public Employee getOneEmployee() {

        return new Employee(101L, "nila-101", 1000.d);
    }

    @GetMapping(path = "/employee/{id}", headers = "Accept=application/json, application/xml")
    public Employee getEmployee(@PathVariable("id") Long id) {

       // Employee e = employeeJDBCService.getEmployee(id);

      //  Employee e = employeeJPARepositoryService.getEmployee(id);
        Employee e = employeeMongoRepositoryService.getEmployee(id);
      //  Employee e = service.getEmployee(id);

        if (e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for id " + id);
        }
        return e;
    }

    @GetMapping(path = "/employee", headers = "Accept=application/json, application/xml")
    public Employee queryEmployee(@RequestParam(name = "id", required = false, defaultValue = "101") Long id) {

       // Employee e = employeeJDBCService.getEmployee(id);
       // Employee e = employeeJPARepositoryService.getEmployee(id);
        Employee e = employeeMongoRepositoryService.getEmployee(id);
       // Employee e = service.getEmployee(id);

        if (e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for id " + id);
        }
        return e;
    }


    @PostMapping(path = "/employee", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee emp) {

        return employeeMongoRepositoryService.addEmployee(emp);
      //return employeeJPARepositoryService.addEmployee(emp);
      //  return employeeJDBCService.addEmployee(emp);
       // return service.addEmployee(emp);
    }

    @DeleteMapping(path = "/employee/{id}", headers = {"Accept=application/json, application/xml"})
    public void deleteEmployee(@PathVariable("id") Long id) {

           employeeMongoRepositoryService.deleteEmployee(id);
        //employeeJPARepositoryService.deleteEmployee(id);
        //service.deleteEmployee(id);
    }

    @PutMapping(path = "/employee/{id}", headers = {"Content-Type=application/json, application/xml",
            "Accept=application/json, application/xml"})
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {

        employeeMongoRepositoryService.updateEmployee(id, emp);
      //  employeeJPARepositoryService.updateEmployee(id, emp);
     //  service.updateEmployee(id, emp);
    }

}
