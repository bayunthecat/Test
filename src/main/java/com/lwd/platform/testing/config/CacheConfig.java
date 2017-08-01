package com.lwd.platform.testing.config;

import org.ehcache.config.CacheConfiguration;

public interface CacheConfig<K, V> {

    String getCacheName();

    CacheConfiguration<K, V> getCacheConfig();
}
