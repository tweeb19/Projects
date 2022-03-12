package com.revature;

import com.revature.Employee;

import java.sql.SQLException;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;

    //collection list
    List<Employee> getEmployees() throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
}

