package com.lwd.platform.testing.init;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class MySqlDataSourceInitializer {

    private final DataSource dataSource;

    @Autowired
    public MySqlDataSourceInitializer(@Qualifier("rawDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer dsi = new DataSourceInitializer();
        dsi.setDataSource(dataSource);
        dsi.setDatabasePopulator(getDatabasePopulator());
        return dsi;
    }

    private DatabasePopulator getDatabasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        //TODO make separate resource folder and reads scripts
        populator.addScript(new ClassPathResource("schema.sql"));
        populator.addScript(new ClassPathResource("init-database.sql"));
        return populator;
    }
}