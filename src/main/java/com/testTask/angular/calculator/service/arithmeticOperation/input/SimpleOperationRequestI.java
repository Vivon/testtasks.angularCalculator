package com.testTask.angular.calculator.service.arithmeticOperation.input;

/**
 * Request for simple arithmetic operation
 */
public interface SimpleOperationRequestI {

    /**
     * First argument for operation
     */
    Double getFirstArgument();

    /**
     * Second argument for operation
     */
    Double getSecondArgument();

    /**
     * Unique symbolic identifier operation
     */
    String getOperationToken();

}
