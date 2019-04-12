package com.leonardostc.cs545waalab8.dto;

import java.util.ArrayList;
import java.util.List;

public class DomainErrors {

    private String errorType;
    private String message;

    private List<DomainError> errors = new ArrayList<>();

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DomainError> getErrors() {
        return errors;
    }

    public void setErrors(List<DomainError> errors) {
        this.errors = errors;
    }

    public void addError(DomainError error){
        this.errors.add(error);
    }
}
