package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ServiceException;

public class DivisionByZeroException extends ServiceException {

    private static final ErrorNumber ERROR = ErrorNumber.ERR_01_2;

    public DivisionByZeroException() {
        super(ERROR);
    }
}
