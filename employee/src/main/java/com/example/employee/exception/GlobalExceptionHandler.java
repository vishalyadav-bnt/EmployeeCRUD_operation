package com.example.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employee.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER=LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ObjectISNull.class)
    public ResponseEntity<ErrorResponse>handleObjectIsNull(ObjectISNull e)
    {
        LOGGER.info("Object Is Empty {}"+e.getMessage());
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(),HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);


    }
    @ExceptionHandler(IdNotFound.class)
    public ResponseEntity<ErrorResponse>handleObjectIsNull(IdNotFound e)
    {
        LOGGER.info("Id Not Found"+e.getMessage());
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(),HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);


    }
}
