package com.example.demoRestApp;

import com.example.demoRestApp.dao.EmployeeJPA;
import com.example.demoRestApp.dao.EmployeeJPARepository;
import com.example.demoRestApp.mongo.EmployeeMongo;
import com.example.demoRestApp.mongo.EmployeeMongoRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
@Slf4j
public class EmployeeMongoRepositoryService {

    @Autowired
    EmployeeMongoRepository employeeMongoRepository;


    public Employee getEmployee(long id) {

       Optional<EmployeeMongo> e =  employeeMongoRepository.findById(id);

       if (e.isPresent()) {
           EmployeeMongo e1 = e.get();
           Employee employee = new Employee(e1.getId(), e1.getName(), e1.getSal());
           return employee;
       } else {
           return null;
       }
    }
//
    @Transactional
    public Employee addEmployee(Employee employee) {

        EmployeeMongo existing = employeeMongoRepository.findByName(employee.getName());

        if(existing == null) {
            EmployeeMongo e  = new EmployeeMongo();
        e.setName(employee.getName());
        e.setSal(employee.getSal());

        e = employeeMongoRepository.save(e);

        employee.setId(e.getId());
        return employee;
        } else {
            return   new Employee(existing.getId(), existing.getName(), existing.getSal());
        }

    }
//
    @Transactional
    public void deleteEmployee(long id) {
        employeeMongoRepository.deleteById(id);
    }
//
    @Transactional
    public void updateEmployee(long id, Employee employee) {

        Optional<EmployeeMongo> e =  employeeMongoRepository.findById(id);
        if (e.isPresent()) {
            EmployeeMongo e1 = e.get();
            e1.setSal(employee.getSal());
            employeeMongoRepository.save(e1);
        }
    }

}
