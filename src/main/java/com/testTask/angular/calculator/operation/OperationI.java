package com.testTask.angular.calculator.operation;

import com.testTask.angular.calculator.common.ServiceException;

public interface OperationI <T> {

    T doOperation(T firstArgument, T secondArgument) throws ServiceException;
}
