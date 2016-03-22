package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.operation.OperationI;
import org.springframework.stereotype.Component;

@Component
public class MultiplicationOperation implements OperationI<Double> {

    @Override
    public Double doOperation(Double firstArgument, Double secondArgument) {
        return firstArgument * secondArgument;
    }
}
