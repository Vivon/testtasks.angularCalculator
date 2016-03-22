package com.testTask.angular.calculator.common;

public class ServiceException extends Exception {

    private ErrorNumber errorNumber;

    protected ServiceException(ErrorNumber errorNumber) {
        this.errorNumber = errorNumber;
    }

    public ErrorNumber getErrorNumber() {
        return errorNumber;
    }
}
