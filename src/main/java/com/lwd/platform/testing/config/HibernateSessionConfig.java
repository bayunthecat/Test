package com.lwd.platform.testing.config;

import com.lwd.platform.testing.util.constant.Const;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HibernateSessionConfig {

    private List<WeakReference<Session>> sessionList = new ArrayList<>();

    private static final Logger LOG = Logger.getLogger(HibernateSessionConfig.class);

    @Autowired
    private SessionFactory factory;

    @Autowired
    private Session session;

    @Bean(destroyMethod = Const.Bean.DestroyMethods.CLOSE)
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
    public Session getSession() {
        Session session = factory.openSession();
        sessionList.add(new WeakReference<>(session));
        printDetailedStatistic();
        return session;
    }

    //TODO debug method remove later
    private void printDetailedStatistic() {
        LOG.info(
                "Sessions count -> " + sessionList.stream().filter(ref -> ref.get() != null).count() +
                ", opened sessions -> " + sessionList.stream().filter(ref -> ref.get() != null).filter(ref -> ref.get().isOpen()).count());
    }
}
