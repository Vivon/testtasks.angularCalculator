package com.testTask.angular.calculator.web;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ExceptionResponse;
import com.testTask.angular.calculator.common.ServiceException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class WebExceptionHandler {

    private static final Integer DEFAULT_ERROR_STATUS = 500;

    @ExceptionHandler
    public @ResponseBody ExceptionResponse serverHandlerServiceException(ServiceException exception, HttpServletResponse response){
        response.setStatus(DEFAULT_ERROR_STATUS);
        return new ExceptionResponse(exception.getErrorNumber().name(), exception.getMessage());
    }

    @ExceptionHandler
    public @ResponseBody ExceptionResponse defaultHandlerException(Exception exception, HttpServletResponse response){
        response.setStatus(DEFAULT_ERROR_STATUS);
        return new ExceptionResponse(ErrorNumber.ERR_01_0.name(), ErrorNumber.ERR_01_0.getErrorMessage(), exception.getMessage());
    }
    @ExceptionHandler
    public @ResponseBody ExceptionResponse notReadableRequesHandlerException(
            HttpMessageNotReadableException httpMessageNotReadableException, HttpServletResponse response){
        response.setStatus(DEFAULT_ERROR_STATUS);
        return new ExceptionResponse(ErrorNumber.ERR_00_0.name(), ErrorNumber.ERR_00_0.getErrorMessage(), httpMessageNotReadableException.getMessage());
    }
}
