package com.app.service;

import com.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmpFromId(int id);
    public void deleteEmployee(int id);
}
