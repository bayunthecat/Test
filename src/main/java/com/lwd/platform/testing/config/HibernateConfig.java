package com.lwd.platform.testing.config;

import com.lwd.platform.testing.model.business.ModelEntity;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.JTASessionContext;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getLocalSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages(ModelEntity.class.getPackage().getName());
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", MySQLDialect.class.getName());
        properties.setProperty("hibernate.current_session_context_class", JTASessionContext.class.getName());
        properties.setProperty("hibernate.show_sql", String.valueOf(true));
        properties.setProperty("hibernate.jdbc.batch_size", "50");
        return properties;
    }
}
