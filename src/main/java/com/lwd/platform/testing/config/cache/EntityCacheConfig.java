package com.lwd.platform.testing.config.cache;

import com.lwd.platform.testing.config.CacheConfig;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityCacheConfig implements CacheConfig<Object, Object> {

    public static final String CACHE_NAME = "entityCache";

    private static final int CAPACITY = 10;

    @Override
    public CacheConfiguration<Object, Object> getCacheConfig() {
        return CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(CAPACITY)).build();
    }

    @Override
    public String getCacheName() {
        return CACHE_NAME;
    }

}