package com.example.demoRestApp.dao;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeJPARepository extends CrudRepository<EmployeeJPA, Long> {

    EmployeeJPA findByName(String name);
}
