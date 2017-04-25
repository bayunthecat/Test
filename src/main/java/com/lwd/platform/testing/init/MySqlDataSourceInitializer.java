package com.lwd.platform.testing.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSourceInitializer {

    @Bean
    @Autowired
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dsi = new DataSourceInitializer();
        dsi.setDataSource(dataSource);
        dsi.setDatabasePopulator(getDatabasePopulator());
        return dsi;
    }

    private DatabasePopulator getDatabasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("schema.sql"));
        return populator;
    }
}
