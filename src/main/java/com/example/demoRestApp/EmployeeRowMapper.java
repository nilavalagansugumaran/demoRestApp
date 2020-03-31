package com.example.demoRestApp;

//import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper {//implements RowMapper<Employee> {

  //  @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(resultSet.getLong("employeeid"),
                resultSet.getString("Name"),
                resultSet.getDouble("Salary"));
    }
}
