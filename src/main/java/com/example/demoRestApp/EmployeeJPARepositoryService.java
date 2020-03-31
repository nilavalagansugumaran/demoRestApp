package com.example.demoRestApp;

import com.example.demoRestApp.dao.EmployeeJPA;
import com.example.demoRestApp.dao.EmployeeJPARepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Data
@Service
@Slf4j
public class EmployeeJPARepositoryService {

    @Autowired
    EmployeeJPARepository employeeJPARepository;


    public Employee getEmployee(long id) {

       Optional<EmployeeJPA> e =  employeeJPARepository.findById(id);

       if (e.isPresent()) {
           EmployeeJPA e1 = e.get();
           Employee employee = new Employee(e1.getId(), e1.getName(), e1.getSal());
           return employee;
       } else {
           return null;
       }
    }
//
    @Transactional
    public Employee addEmployee(Employee employee) {

        EmployeeJPA existing = employeeJPARepository.findByName(employee.getName());

        if(existing == null) {



        EmployeeJPA e  = new EmployeeJPA();
        e.setName(employee.getName());
        e.setSal(employee.getSal());

        e = employeeJPARepository.save(e);

        employee.setId(e.getId());
        return employee;
        } else {
            return   new Employee(existing.getId(), existing.getName(), existing.getSal());
        }

    }
//
    @Transactional
    public void deleteEmployee(long id) {
        employeeJPARepository.deleteById(id);
    }
//
    @Transactional
    public void updateEmployee(long id, Employee employee) {

        Optional<EmployeeJPA> e =  employeeJPARepository.findById(id);
        if (e.isPresent()) {
            EmployeeJPA e1 = e.get();
            e1.setSal(employee.getSal());
            employeeJPARepository.save(e1);
        }
    }

}
