package com.testTask.angular.calculator.validator;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ServiceException;

public class ParamValidationException extends ServiceException {

    private static final ErrorNumber ERROR = ErrorNumber.ERR_00_1;
    private String paramAlias;

    public ParamValidationException(String paramAlias) {
        super(ERROR);
        this.paramAlias = paramAlias;
    }

    @Override
    public String getMessage() {
        return String.format(super.getMessage(), paramAlias);
    }
}
