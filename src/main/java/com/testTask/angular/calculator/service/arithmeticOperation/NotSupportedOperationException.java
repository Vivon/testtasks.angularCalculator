package com.testTask.angular.calculator.service.arithmeticOperation;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ServiceException;

public class NotSupportedOperationException extends ServiceException {

    private static final ErrorNumber ERROR = ErrorNumber.ERR_01_1;

    public NotSupportedOperationException() {
        super(ERROR);
    }
}
