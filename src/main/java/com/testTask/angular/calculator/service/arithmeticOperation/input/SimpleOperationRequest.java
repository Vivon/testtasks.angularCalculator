package com.testTask.angular.calculator.service.arithmeticOperation.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testTask.angular.calculator.web.constAlias.RequestAlias;

public class SimpleOperationRequest implements SimpleOperationRequestI {

    @JsonProperty(value = RequestAlias.FIRST_ARGUMENT_ALIAS, required = false)
    private Double firstArgument;

    @JsonProperty(value = RequestAlias.SECOND_ARGUMENT_ALIAS, required = false)
    private Double secondArgument;

    @JsonProperty(value = RequestAlias.OPERATION_ALIAS, required = false)
    private String operationToken;

    @Override
    public Double getFirstArgument() {
        return firstArgument;
    }

    @Override
    public Double getSecondArgument() {
        return secondArgument;
    }

    @Override
    public String getOperationToken() {
        return operationToken;
    }
}
