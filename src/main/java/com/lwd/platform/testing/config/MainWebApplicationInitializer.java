package com.lwd.platform.testing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lwd.platform.testing")
@EnableAspectJAutoProxy
public class MainWebApplicationInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET = "dispatcher";

    private static final int LOAD_ON_STARTUP = 1;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
        xmlWebApplicationContext.setConfigLocation("/META-INF/spring/context.xml");
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET, new DispatcherServlet(xmlWebApplicationContext));
        registration.setLoadOnStartup(LOAD_ON_STARTUP);
        registration.addMapping("/*");
        servletContext.addListener(new RequestContextListener());
    }
}
