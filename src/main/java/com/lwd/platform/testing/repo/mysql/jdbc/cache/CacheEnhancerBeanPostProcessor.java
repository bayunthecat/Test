package com.lwd.platform.testing.repo.mysql.jdbc.cache;

import java.lang.reflect.Proxy;

import com.lwd.platform.testing.annotations.Cached;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CacheEnhancerBeanPostProcessor implements BeanPostProcessor {

    private CacheManager cacheManager;

    public CacheEnhancerBeanPostProcessor(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(Cached.class)) {
            Cached annotation = clazz.getAnnotation(Cached.class);
            int cacheCapacity = annotation.capacity();
            bean = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new CacheLayerProxy(bean, cacheManager.createCache(
                    beanName,
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(cacheCapacity)).build())));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}