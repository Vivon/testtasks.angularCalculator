package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.common.ServiceException;
import com.testTask.angular.calculator.operation.OperationI;
import org.springframework.stereotype.Component;

@Component
public class DivisionOperation implements OperationI<Double> {

    private static final Double ZERO_ARGUMENT_CONSTANT = 0D;

    @Override
    public Double doOperation(Double firstArgument, Double secondArgument) throws ServiceException {
        if (secondArgument == null || ZERO_ARGUMENT_CONSTANT.equals(secondArgument)) {
            throw new DivisionByZeroException();
        }
        return firstArgument / secondArgument;
    }
}
