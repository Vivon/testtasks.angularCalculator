package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.operation.OperationI;

public abstract class OperationABS <T> implements OperationI<T> {

    protected static final Double ZERO_ARGUMENT_CONSTANT = 0D;

    protected Double prepareArgument(Double argument) {
        if (argument == null) {
            return ZERO_ARGUMENT_CONSTANT;
        }
        return argument;
    }
}
