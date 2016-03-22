package com.testTask.angular.calculator.operation;

public enum OperationEnum {

    SUM("+"), UNDEF(""), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

    private String stringValue;

    OperationEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static OperationEnum valueOfString(String operationString){
        for (OperationEnum operation : OperationEnum.values()) {
            if (operation.stringValue.equals(operationString)){
                return operation;
            }
        }
        return UNDEF;
    }
}
