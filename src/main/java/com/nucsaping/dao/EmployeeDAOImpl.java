package com.nucsaping.dao;

import com.nucsaping.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String hashReference = "Employee";

    @Resource(name = "redisTemplate") // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Employee> hashOperations;

    @Override
    public void saveEmployee(Employee emp) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, emp.getEmployeeId(), emp);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        hashOperations.put(hashReference, emp.getEmployeeId(), emp);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteEmployee(Integer id) {
        hashOperations.delete(hashReference, id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOperations.putAll(hashReference, map);
    }
}
