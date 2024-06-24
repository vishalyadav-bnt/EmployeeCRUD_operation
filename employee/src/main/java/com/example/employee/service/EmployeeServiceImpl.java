package com.example.employee.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.exception.ObjectISNull;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repositiory.EmployeeRepositiory;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepositiory employeeRepositiory;

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
       if(employeeModel==null)
       {
        throw new ObjectISNull("Object Is Null");
       }
       EmployeeModel storeEmployee=employeeRepositiory.save(employeeModel);
       return storeEmployee;
    }

    @Override
    public int getAgeById(int id) {
      Optional<EmployeeModel> checkId=employeeRepositiory.findById(id);
        if(checkId.isPresent())
        {
            EmployeeModel fetchEmployeeModel=checkId.get();
            LocalDate birthDate=fetchEmployeeModel.getBirthDate().toLocalDate();
            LocalDate currDate=LocalDate.now();
            Period period=Period.between(birthDate, currDate);
            return period.getYears(); 
        }
        else
        {
            throw new ObjectISNull("Id Not Found");
        }
    }

    @Override
    public List<EmployeeModel> getAllEmployee() {
       List<EmployeeModel>list=employeeRepositiory.findAll();
       if(list.isEmpty())
       {

       }
       return list;
    }
}
