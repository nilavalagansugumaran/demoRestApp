package com.example.demoRestApp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Data
@Service
@Slf4j
public class EmployeeService {

    private static ConcurrentHashMap<Long, Employee> employeeMock = new ConcurrentHashMap<>();

    static {
        employeeMock.put(101L, new Employee(101L, "nila-101", 1000.0d));
        employeeMock.put(102L, new Employee(102L, "nila-102", 2000.0d));
        employeeMock.put(103L, new Employee(103L, "nila-103", 3000.0d));
    }

    public Employee getEmployee(long id) {

        return employeeMock.get(id);
    }

    public Employee addEmployee(Employee employee) {

        long empId = employeeMock.size() + 100 + 1;
        employee.setId(empId);
        return employeeMock.put(empId, employee);
    }

    public void deleteEmployee(long id) {

        employeeMock.remove(id);
    }

    public void updateEmployee(long id, Employee employee) {

        Employee e = employeeMock.get(id);
        e.setSal(employee.getSal());
        employeeMock.replace(id, e);
    }

}
