package com.lwd.platform.testing.config.cache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhCacheManagerConfig {

    @Bean
    public CacheManager getCacheManager() {
        CacheManagerBuilder cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder();
        CacheManager cacheManager =  cacheManagerBuilder.build();
        cacheManager.init();
        return cacheManager;
    }
}