package com.lwd.platform.testing.repo.mysql.jdbc.cache;

import java.lang.reflect.Proxy;

import com.lwd.platform.testing.annotations.Cached;
import com.lwd.platform.testing.repo.CrudDao;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CacheEnhancerBeanPostProcessor implements BeanPostProcessor {

    private static final int CAPACITY = 10;

    private CacheManager cacheManager;

    public CacheEnhancerBeanPostProcessor(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (bean instanceof CrudDao && clazz.isAnnotationPresent(Cached.class)) {
            bean = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new CacheProxy(bean, cacheManager.createCache(beanName, CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(CAPACITY)).build())));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}