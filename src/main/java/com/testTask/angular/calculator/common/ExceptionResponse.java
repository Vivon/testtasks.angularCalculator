package com.testTask.angular.calculator.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {

    @JsonProperty(value = "code", required = false)
    private String code;

    @JsonProperty(value = "message", required = false)
    private String message;

    @JsonProperty(value = "detail", required = false)
    private String detail;

    public ExceptionResponse(String code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
