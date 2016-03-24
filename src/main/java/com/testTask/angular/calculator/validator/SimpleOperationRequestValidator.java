package com.testTask.angular.calculator.validator;

import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequestI;
import com.testTask.angular.calculator.web.constAlias.RequestAlias;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SimpleOperationRequestValidator implements ValidatorI<SimpleOperationRequestI> {

    @Override
    public void validate(SimpleOperationRequestI operationRequest) throws ParamValidationException, RequestWrongException {
        if (operationRequest == null) {
            throw new RequestWrongException();
        }
        if (operationRequest.getFirstArgument() == null) {
            throw new ParamValidationException(RequestAlias.FIRST_ARGUMENT_ALIAS);
        }
        if (StringUtils.isEmpty(operationRequest.getOperationToken())) {
            throw new ParamValidationException(RequestAlias.OPERATION_ALIAS);
        }
    }
}
