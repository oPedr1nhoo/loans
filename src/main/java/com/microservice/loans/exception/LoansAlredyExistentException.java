package com.microservice.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoansAlredyExistentException extends RuntimeException {

    public LoansAlredyExistentException(String message)
    {
        super(message);
    }
}
