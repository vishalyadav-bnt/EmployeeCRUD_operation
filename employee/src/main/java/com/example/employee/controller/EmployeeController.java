package com.example.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.EmployeeModel;
import com.example.employee.response.SuccessResponse;
import com.example.employee.service.EmployeeServiceImpl;

@RestController
//@RequestMapping("v1/employee")
public class EmployeeController {
    private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/")
    public ResponseEntity<SuccessResponse> saveEmployee(@Validated @RequestBody EmployeeModel employeeModel)
    {
       LOGGER.info("Request coming for storeemployee object");
       EmployeeModel storeEmployee=employeeServiceImpl.saveEmployee(employeeModel);
       SuccessResponse response=new SuccessResponse("Data Is stored",HttpStatus.OK.value(),storeEmployee);
       LOGGER.info("Employee Store Succesfully");
       return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SuccessResponse>getAgeById(@PathVariable("id")int id)
    {
        LOGGER.info("Request for fetch age by id {}"+id);
        int  EmployeeAge=employeeServiceImpl.getAgeById(id);
        SuccessResponse successResponse=new SuccessResponse("The Age Of The Employee Is",HttpStatus.OK.value(),EmployeeAge);
        LOGGER.info("Send Response Succesfully");
        return new ResponseEntity<>(successResponse,HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<SuccessResponse>getAllEmployee()
    {
        LOGGER.info("Request coming for fetch all data");
        List<EmployeeModel>list=employeeServiceImpl.getAllEmployee();
        SuccessResponse successResponse=new SuccessResponse("Data Fetch Succesfully",HttpStatus.OK.value(),list);
        LOGGER.info("Send Response Send Succesfully");
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }

    @GetMapping("/sayhello")
    public String sayHello()
    {
        return "Success...";
    }

    


}
