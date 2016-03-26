package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.common.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class DivisionOperation extends OperationABS<Double> {

    @Override
    public Double doOperation(Double firstArgument, Double secondArgument) throws ServiceException {
        if (secondArgument == null || ZERO_ARGUMENT_CONSTANT.equals(secondArgument)) {
            throw new DivisionByZeroException();
        }
        return prepareArgument(firstArgument) / secondArgument;
    }
}
