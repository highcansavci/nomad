package com.example.application.views.employee.service;

import java.util.List;

import com.example.application.views.employee.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> filterEmployeesByName(String nameFilter);
}
