package com.testTask.angular.calculator.operation.arithmetic.simple;

import org.springframework.stereotype.Component;

@Component
public class SumOperation extends OperationABS<Double>{

    public Double doOperation(Double firstArgument, Double secondArgument){
        return prepareArgument(firstArgument) + prepareArgument(secondArgument);
    }
}
