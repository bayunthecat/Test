package com.lwd.platform.testing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = {"com.lwd.platform.testing.web"}
)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/external/");
        registry.addResourceHandler("/components/**").addResourceLocations("/WEB-INF/components/");
        registry.addResourceHandler("/pages/**").addResourceLocations("/WEB-INF/pages/");
        registry.addResourceHandler("/wro/**").addResourceLocations("/WEB-INF/wro/");
        super.addResourceHandlers(registry);
    }
}
