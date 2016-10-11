package com.lwd.platform.testing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
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
