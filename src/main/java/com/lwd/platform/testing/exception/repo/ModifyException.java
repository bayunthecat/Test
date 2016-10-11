package com.lwd.platform.testing.exception.repo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No id specified")
public class ModifyException extends RuntimeException {

    public ModifyException() {
    }

    public ModifyException(String message) {
        super(message);
    }

    public ModifyException(String message, Throwable cause) {
        super(message, cause);
    }
}
