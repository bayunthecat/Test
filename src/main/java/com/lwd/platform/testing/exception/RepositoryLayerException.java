package com.lwd.platform.testing.exception;

public class RepositoryLayerException extends RuntimeException {

    public RepositoryLayerException() {
    }

    public RepositoryLayerException(String message) {
        super(message);
    }

    public RepositoryLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
