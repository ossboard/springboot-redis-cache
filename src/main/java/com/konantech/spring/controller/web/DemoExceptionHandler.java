package com.konantech.spring.controller.web;

import com.konantech.spring.exceptions.DemoNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DemoExceptionHandler {

    private Logger log = LoggerFactory.getLogger(DemoExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post Not Found")
    @ExceptionHandler(DemoNotFoundException.class)
    public void handlePostNotFound(HttpServletRequest request, Exception ex) {
        log.error("{} : {}", ex.getMessage(), request.getRequestURI());
    }
}
