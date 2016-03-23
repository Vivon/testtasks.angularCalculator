package com.testTask.angular.calculator.validator;

public interface ValidatorI<T>  {

    void validate(T arg) throws ParamValidationException;

}
