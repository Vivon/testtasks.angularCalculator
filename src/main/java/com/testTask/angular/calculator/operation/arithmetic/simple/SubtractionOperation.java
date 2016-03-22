package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.operation.OperationI;
import org.springframework.stereotype.Component;

@Component
public class SubtractionOperation implements OperationI<Double> {

    public Double doOperation(Double firstArgument, Double secondArgument) {
        return firstArgument - secondArgument;
    }
}