package com.example.application.views.employee.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.views.employee.model.Employee;
import com.example.application.views.employee.service.EmployeeService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Employee>> filterEmployeesByName(String nameFilter) {
        return ResponseEntity.ok(employeeService.filterEmployeesByName(nameFilter));
    }
}
