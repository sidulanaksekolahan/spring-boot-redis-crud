package com.nucsaping.service;

import com.nucsaping.dao.EmployeeDAO;
import com.nucsaping.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void saveEmployee(Employee emp) {
        employeeDAO.saveEmployee(emp);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return employeeDAO.getOneEmployee(id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeDAO.updateEmployee(emp);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        employeeDAO.saveAllEmployees(map);
    }
}
