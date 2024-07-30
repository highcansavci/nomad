package com.example.application.views.employee.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.example.application.views.employee.model.Employee;
import com.example.application.views.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new CopyOnWriteArrayList<>();

    public EmployeeServiceImpl() {
        employees.add(new Employee(1L, "12345678901", "Can", "Savcı"));
        employees.add(new Employee(2L, "54623499010", "Ali", "Savcı"));
        employees.add(new Employee(3L, "72349123041", "Veli", "Savcı"));
        employees.add(new Employee(4L, "43534596032", "Ahmet", "Savcı"));
        employees.add(new Employee(5L, "45213812301", "Mehmet", "Savcı"));
        employees.add(new Employee(6L, "26948739404", "Ekrem", "Savcı"));
        employees.add(new Employee(7L, "34984759303", "Ayşe", "Savcı"));
        employees.add(new Employee(8L, "45678901234", "Fatma", "Savcı"));
        employees.add(new Employee(9L, "49329234051", "Hüsne", "Savcı"));
        employees.add(new Employee(10L, "12334995036", "Alara", "Savcı"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public List<Employee> filterEmployeesByName(String nameFilter) {
        return employees.stream().filter((employee) -> employee.getName().toLowerCase().contains(nameFilter)).toList();
    }
    
}
