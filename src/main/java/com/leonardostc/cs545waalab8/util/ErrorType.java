package com.leonardostc.cs545waalab8.util;

public enum ErrorType {
    ValidationError ("ValidationError");

    private final String type;
    private ErrorType(String errorType) {
        type=errorType;
    }

    public String toString(){
        return this.type.toString();
    }
}
