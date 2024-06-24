package com.example.employee.service;

import java.util.List;

import com.example.employee.model.EmployeeModel;

public interface EmployeeService {
    public EmployeeModel saveEmployee(EmployeeModel employeeModel);
    public int  getAgeById(int id);
    public List<EmployeeModel>getAllEmployee();

}
