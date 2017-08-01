package com.lwd.platform.testing.repo.mysql.jdbc.aspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionTranslatorAspect {

    private Map<Class<? extends Exception>, Class<? extends RuntimeException>> exceptionMapping;

    public ExceptionTranslatorAspect(Map<Class<? extends Exception>, Class<? extends RuntimeException>> exceptionMapping) {
        this.exceptionMapping = exceptionMapping;
    }

    @Around("within(com.lwd.platform.testing.repo.mysql.jdbc.impl..*)")
    public Object translate(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        try {
            result = point.proceed();
        } catch (RuntimeException e) {
            Class<? extends RuntimeException> clazz = e.getClass();
            Class<?> translatedClass = exceptionMapping.get(clazz);
            rethrow(translatedClass, e);
        }
        return result;
    }

    private void rethrow(Class<?> translatedExceptionClass, RuntimeException originalException) {
        try {
            Constructor<?> constructor = translatedExceptionClass.getConstructor(String.class, Throwable.class);
            throw (RuntimeException) constructor.newInstance(originalException.getMessage(), originalException.getCause());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw originalException;
        }
    }

}