package com.testTask.angular.calculator.operation.arithmetic.simple;

import org.springframework.stereotype.Component;

@Component
public class MultiplicationOperation extends OperationABS<Double> {

    @Override
    public Double doOperation(Double firstArgument, Double secondArgument) {
        return prepareArgument(firstArgument) * prepareArgument(secondArgument);
    }
}
