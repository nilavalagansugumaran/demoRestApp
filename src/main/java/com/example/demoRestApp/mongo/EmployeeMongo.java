package com.example.demoRestApp.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class EmployeeMongo {

    @Id
    private Long id = -1l;
    private String name;

    @Field(name = "salary")
    private Double sal;
}
