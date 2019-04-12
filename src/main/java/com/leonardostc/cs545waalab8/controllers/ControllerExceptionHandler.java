package com.leonardostc.cs545waalab8.controllers;

import com.leonardostc.cs545waalab8.dto.DomainError;
import com.leonardostc.cs545waalab8.dto.DomainErrors;
import com.leonardostc.cs545waalab8.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DomainErrors handleException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        DomainErrors domainErrors = new DomainErrors();

        domainErrors.setErrorType(ErrorType.ValidationError.toString());
        fieldErrors.forEach(fieldError -> domainErrors.addError(new DomainError(messageSourceAccessor.getMessage(fieldError))));
        return domainErrors;
    }

}
