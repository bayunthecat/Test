package com.lwd.platform.testing.config;

import com.lwd.platform.testing.service.converter.UserBeanConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;

@Configuration
public class ConversionServiceConfiguration {

    private static final String CONVERSION_SERVICE = "conversionService";

    @Autowired
    @Bean(name = CONVERSION_SERVICE)
    public ConversionServiceFactoryBean getConversionService(UserBeanConverter userBeanConverter) {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(new HashSet<Converter>() {
            {
                add(userBeanConverter);
            }
        });
        return factory;
    }
}
