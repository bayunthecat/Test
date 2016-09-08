package com.lwd.platform.testing.web.exception;

import com.lwd.platform.testing.web.wrapper.BadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public BadResponse handleException(HttpServletRequest request, Exception e) {
        BadResponse response = new BadResponse();
        response.setException(e.getClass().getName());
        response.setMessage(e.getMessage());
        return response;
    }
}
