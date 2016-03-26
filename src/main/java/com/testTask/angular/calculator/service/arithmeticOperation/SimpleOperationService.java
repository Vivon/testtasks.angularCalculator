package com.testTask.angular.calculator.service.arithmeticOperation;

import com.testTask.angular.calculator.common.ServiceException;
import com.testTask.angular.calculator.operation.OperationEnum;
import com.testTask.angular.calculator.operation.OperationI;
import com.testTask.angular.calculator.operation.arithmetic.simple.DivisionOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.MultiplicationOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.SubtractionOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.SumOperation;
import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequestI;
import com.testTask.angular.calculator.validator.SimpleOperationRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleOperationService implements SimpleOperationServiceI {

    @Autowired
    private SumOperation sumOperation;

    @Autowired
    private SubtractionOperation subtractionOperation;

    @Autowired
    private MultiplicationOperation multiplicationOperation;

    @Autowired
    private DivisionOperation divisionOperation;

    @Autowired
    private SimpleOperationRequestValidator simpleOperationRequestValidator;

    @Override
    public Double doOperation(SimpleOperationRequestI simpleOperationRequest) throws ServiceException {
        simpleOperationRequestValidator.validate(simpleOperationRequest);
        OperationI<Double> operation = getOperation(simpleOperationRequest);
        return operation.doOperation(simpleOperationRequest.getFirstArgument(), getSecondArgument(simpleOperationRequest));
    }

    private Double getSecondArgument(SimpleOperationRequestI simpleOperationRequest){
        if (simpleOperationRequest.getSecondArgument() == null) {
            return simpleOperationRequest.getFirstArgument();
        }
        return simpleOperationRequest.getSecondArgument();
    }

    private OperationI getOperation(SimpleOperationRequestI simpleOperationRequest) throws NotSupportedOperationException {
        switch(OperationEnum.valueOfString(simpleOperationRequest.getOperationToken())) {
            case SUM: return sumOperation;
            case SUBTRACTION: return subtractionOperation;
            case MULTIPLICATION: return multiplicationOperation;
            case DIVISION: return divisionOperation;
            default: throw new NotSupportedOperationException();
        }
    }

    void setSumOperation(SumOperation sumOperation) {
        this.sumOperation = sumOperation;
    }

    void setSubtractionOperation(SubtractionOperation subtractionOperation) {
        this.subtractionOperation = subtractionOperation;
    }

    void setMultiplicationOperation(MultiplicationOperation multiplicationOperation) {
        this.multiplicationOperation = multiplicationOperation;
    }

    void setDivisionOperation(DivisionOperation divisionOperation) {
        this.divisionOperation = divisionOperation;
    }

    void setSimpleOperationRequestValidator(SimpleOperationRequestValidator simpleOperationRequestValidator) {
        this.simpleOperationRequestValidator = simpleOperationRequestValidator;
    }
}
