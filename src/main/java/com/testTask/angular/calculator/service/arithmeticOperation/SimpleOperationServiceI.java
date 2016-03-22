package com.testTask.angular.calculator.service.arithmeticOperation;

import com.testTask.angular.calculator.common.ServiceException;
import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequestI;

public interface SimpleOperationServiceI {

    Double doOperation(SimpleOperationRequestI simpleOperationRequest) throws ServiceException;

}
