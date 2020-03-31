package com.example.demoRestApp.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongo, Long> {

    EmployeeMongo findByName(String name);
}
