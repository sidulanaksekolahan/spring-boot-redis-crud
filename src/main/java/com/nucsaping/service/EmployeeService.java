package com.nucsaping.service;

import com.nucsaping.model.Employee;

import java.util.Map;

public interface EmployeeService {

    void saveEmployee(Employee emp);

    Employee getOneEmployee(Integer id);

    void updateEmployee(Employee emp);

    Map<Integer, Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    void saveAllEmployees(Map<Integer, Employee> map);
}
