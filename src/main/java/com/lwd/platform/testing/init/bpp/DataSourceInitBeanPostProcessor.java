package com.lwd.platform.testing.init.bpp;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import javax.sql.DataSource;

import com.lwd.platform.testing.init.MySqlDataSourceInitializer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class DataSourceInitBeanPostProcessor implements BeanPostProcessor {

    private DataSource dataSource;

    @Autowired
    public DataSourceInitBeanPostProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (bean.getClass() == MySqlDataSourceInitializer.class) {
            Optional<Field> dataSource = Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getType() == DataSource.class).findFirst();
            if (!dataSource.isPresent()) {
                throw new IllegalStateException("Bean " + beanName + " does not have a single data source field.");
            }
            ReflectionUtils.setField(dataSource.get(), bean, dataSource);
        }
        return bean;
    }
}
