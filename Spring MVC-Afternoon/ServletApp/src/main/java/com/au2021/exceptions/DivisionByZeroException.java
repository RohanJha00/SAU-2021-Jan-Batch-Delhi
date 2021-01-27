package com.au2021.exceptions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
public class DivisionByZeroException {

    public DivisionByZeroException() {
        super("division by zero");
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = DivisionByZeroException.class)
    public @ResponseBody
    HashMap<String, String> handleError(HttpServletRequest req, Exception exception) {
        HashMap<String,String> mp = new HashMap<>();
        mp.put("symbol","/");
        mp.put("Message","division by zero");
        return mp;
    }
}
