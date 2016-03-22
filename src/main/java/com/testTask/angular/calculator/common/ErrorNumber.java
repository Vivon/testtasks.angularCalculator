package com.testTask.angular.calculator.common;

public enum ErrorNumber {

    ERR_01_0("Произошла непредвиденная ошибка!"),
    ERR_01_1("Не поддерживаемая арифметическая операция."),
    ERR_01_2("Не возможно делить на 0.");

    private String errorMessage;

    ErrorNumber(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
