package com.lwd.platform.testing.web.exception;

import javax.servlet.http.HttpServletResponse;

import com.lwd.platform.testing.web.wrapper.BadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BadResponse handleException(HttpServletResponse servletResponse, Exception e) {
        BadResponse response = new BadResponse();
        response.setException(e.getClass().getName());
        response.setMessage(e.getMessage());
        setResponseStatus(servletResponse, e);
        return response;
    }

    private void setResponseStatus(HttpServletResponse response, Exception e) {
        ResponseStatus status = e.getClass().getAnnotation(ResponseStatus.class);
        if (status != null) {
            HttpStatus statusCode = status.value();
            response.setStatus(statusCode.value());
        }
    }
}
