package com.elite.project1.springboot1.exceptionHandling;

import com.elite.project1.springboot1.model.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomException employeeNotFountHandler(EmployeeNotFoundException employeeNotFoundException) {
        CustomException customException = new CustomException(HttpStatus.NOT_FOUND, employeeNotFoundException.getMessage());
        return customException;
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomException genericException(Exception e) {
        CustomException customException = new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return customException;
    }
}
