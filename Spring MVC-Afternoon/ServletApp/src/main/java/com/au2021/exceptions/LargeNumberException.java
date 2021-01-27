package com.au2021.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LargeNumberException {

    public LargeNumberException(){
        super("Number is too Large");
    }

    @ExceptionHandler(value = LargeNumberException.class)
    public String handleLargeNumberException() {
        return "large_number_exception";
    }
}
