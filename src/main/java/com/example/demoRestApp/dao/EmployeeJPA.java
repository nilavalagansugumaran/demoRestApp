package com.example.demoRestApp.dao;

import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "EMP")
@Data
public class EmployeeJPA {

   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@Column(name = "salary")
    private Double sal;
}
