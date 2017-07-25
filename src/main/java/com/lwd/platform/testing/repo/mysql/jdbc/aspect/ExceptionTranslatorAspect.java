package com.lwd.platform.testing.repo.mysql.jdbc.aspect;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionTranslatorAspect {

    private static final Logger LOG = Logger.getLogger(ExceptionTranslatorAspect.class);

    private Map<Class<? extends Exception>, Class<? extends RuntimeException>> exceptionMapping;

    public ExceptionTranslatorAspect(Map<Class<? extends Exception>, Class<? extends RuntimeException>> exceptionMapping) {
        this.exceptionMapping = exceptionMapping;
    }

    @Around("within(com.lwd.platform.testing.repo.mysql.jdbc.impl..*)")
    public Object translate(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Throwable throwable) {
            Class<? extends RuntimeException> exceptionClass = exceptionMapping.get(throwable.getClass());
            RuntimeException exception = newInstance(exceptionClass, throwable.getMessage(), throwable.getCause());
            if (exception != null) {
                throw exception;
            } else {
                throw throwable;
            }
        }
    }

    private RuntimeException newInstance(Class<? extends RuntimeException> clazz, String message, Throwable cause) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

}