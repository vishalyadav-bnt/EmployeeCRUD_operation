package com.example.employee.repositiory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.EmployeeModel;

public interface EmployeeRepositiory  extends JpaRepository<EmployeeModel,Integer> {

}
