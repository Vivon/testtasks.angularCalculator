package com.testTask.angular.calculator.common;

/**
 * The parent of all exception
 */
public class ServiceException extends Exception {

    private ErrorNumber errorNumber;

    protected ServiceException(ErrorNumber errorNumber) {
        this.errorNumber = errorNumber;
    }

    public ErrorNumber getErrorNumber() {
        return errorNumber;
    }

    @Override
    public String getMessage() {
        return errorNumber.getErrorMessage();
    }
}
