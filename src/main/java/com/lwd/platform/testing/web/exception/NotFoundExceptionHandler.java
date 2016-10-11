package com.lwd.platform.testing.web.exception;

import com.lwd.platform.testing.web.wrapper.BadResponse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO not working unless disable advice with Exception.class mapping
@ControllerAdvice
public class NotFoundExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public BadResponse handleException(ObjectNotFoundException e) {
        BadResponse response = new BadResponse();
        response.setException(e.getClass().getName());
        response.setMessage(e.getMessage());
        return response;
    }
}
