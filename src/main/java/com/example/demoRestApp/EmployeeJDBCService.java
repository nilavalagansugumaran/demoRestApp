package com.example.demoRestApp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Service
@Slf4j
public class EmployeeJDBCService {

   @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployee(long id) {

        String sql = "SELECT * FROM EMPLOYEES where EMPLOYEEID = ?";
       return jdbcTemplate.queryForObject(sql,  new Object[]{id}, new EmployeeRowMapper());
    }
//
    @Transactional
    public Employee addEmployee(Employee employee) {
         jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{employee.getName(), employee.getSal() });

         return employee;
    }
//
//    public void deleteEmployee(long id) {
//
//    }
//
//    public void updateEmployee(long id, Employee employee) {
//
//
//    }

    @PostConstruct
    public void setupDB() {

        jdbcTemplate.execute("create table EMPLOYEES(" +
                "employeeid int auto_increment, " +
                "name varchar(50), " +
                "salary double, " +
                "primary key (employeeid) )");

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-1", 21000});

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-2", 22000 });

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James-3", 23000});

    }
}
