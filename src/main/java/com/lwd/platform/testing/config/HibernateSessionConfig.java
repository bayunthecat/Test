package com.lwd.platform.testing.config;

import com.lwd.platform.testing.util.constant.Const;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class HibernateSessionConfig {

    @Autowired
    private SessionFactory factory;

    @Autowired
    private Session session;

    @Bean(destroyMethod = Const.Bean.DestroyMethods.CLOSE)
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
    public Session getSession() {
        return factory.openSession();
    }
}
