package com.testTask.angular.calculator.service.arithmeticOperation.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testTask.angular.calculator.web.constAlias.ResponseAlias;

public class SimpleOperationResponse implements SimpleOperationResponseI {

    @JsonProperty(value = ResponseAlias.RESULT_ALIAS, required = false)
    private Double result;

    public SimpleOperationResponse(Double result) {
        this.result = result;
    }

    @Override
    public Double getResult() {
        return result;
    }
}
