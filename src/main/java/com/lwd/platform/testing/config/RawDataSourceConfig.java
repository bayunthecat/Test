package com.lwd.platform.testing.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:mysql.db.properties")
public class RawDataSourceConfig {

    private DataSourceConfig config;

    public RawDataSourceConfig(DataSourceConfig config) {
        this.config = config;
    }

    @Value("${RAW_DB_URL}")
    private String rawDbUrl;

    @Bean(name = "rawDataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = (DriverManagerDataSource) config.getDataSource();
        dataSource.setUrl(rawDbUrl);
        return dataSource;
    }

}
