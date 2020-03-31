package com.example.demoRestApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Employee {

    private Long id;
    private String name;
    private Double sal;
}
