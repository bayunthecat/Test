package com.lwd.platform.testing.config;

import java.util.HashMap;
import java.util.Map;

import com.lwd.platform.testing.exception.EntityNotFoundException;
import com.lwd.platform.testing.repo.mysql.jdbc.aspect.ExceptionTranslatorAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;

@Configuration
public class ExceptionTranslatorConfig {

    @Bean
    public ExceptionTranslatorAspect getExceptionTranslator() {
        Map<Class<? extends Exception>, Class<? extends RuntimeException>> exceptionMapping = new HashMap<>();
        exceptionMapping.put(EmptyResultDataAccessException.class, EntityNotFoundException.class);
        return new ExceptionTranslatorAspect(exceptionMapping);
    }
}
