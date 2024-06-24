package com.example.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.employee.model.EmployeeModel;
import com.example.employee.response.SuccessResponse;

import com.example.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/")
    public ResponseEntity<SuccessResponse> saveEmployee(@RequestBody EmployeeModel employeeModel)
    {
       EmployeeModel storeEmployee=employeeServiceImpl.saveEmployee(employeeModel);
       SuccessResponse response=new SuccessResponse("Data Is stored",HttpStatus.OK.value(),storeEmployee);
       return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SuccessResponse>getAgeById(@PathVariable("id")int id)
    {
        int  EmployeeAge=employeeServiceImpl.getAgeById(id);
        SuccessResponse successResponse=new SuccessResponse("The Age Of The Employee Is",HttpStatus.OK.value(),EmployeeAge);
        return new ResponseEntity<>(successResponse,HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<SuccessResponse>getAllEmployee()
    {
        List<EmployeeModel>list=employeeServiceImpl.getAllEmployee();
        SuccessResponse successResponse=new SuccessResponse("Data Fetch Succesfully",HttpStatus.OK.value(),list);
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }


}
