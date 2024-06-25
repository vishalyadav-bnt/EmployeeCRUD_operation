package com.example.employee.exception;

public class IdNotFound extends RuntimeException {

    public IdNotFound(String str)
    {
        super(str);
    }
}
