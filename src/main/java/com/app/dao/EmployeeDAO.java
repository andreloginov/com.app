package com.app.dao;

import java.util.List;

import com.app.entity.Employee;
public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmpFromId(int id);
    public void deleteEmployee(int id);
}

