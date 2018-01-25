package com.myApp.repository;

import com.myApp.entity.Employee;

import java.util.List;

public interface EmployeeRepository {


    List<Employee> findAll();

    Employee findOne(String id);

    Employee findByEmail(String email);

    Employee create(Employee emp);

    Employee update(String id, Employee emp);

    void delete(Employee emp);
}
