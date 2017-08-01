package com.lwd.platform.testing.config.cache;

import java.util.List;

import com.lwd.platform.testing.config.CacheConfig;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhCacheManagerConfig {

    private List<CacheConfig<?, ?>> cacheConfigs;

    public EhCacheManagerConfig(List<CacheConfig<?, ?>> cacheConfigs) {
        this.cacheConfigs = cacheConfigs;
    }

    @Bean
    public CacheManager getCacheManager() {
        CacheManagerBuilder cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder();
        cacheConfigs.forEach(cacheConfig ->
                cacheManagerBuilder.withCache(cacheConfig.getCacheName(), cacheConfig.getCacheConfig()));
        CacheManager cacheManager =  cacheManagerBuilder.build();
        cacheManager.init();
        return cacheManager;
    }
}