package com.lwd.platform.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceTransactionMangerConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
