package com.lwd.platform.testing.repo.mysql.jdbc.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.ehcache.Cache;

//TODO change name
public class CacheProxy implements InvocationHandler {

    private Object objectToBeProxied;

    private Cache<Object, Object> entityCache;

    public CacheProxy(Object objectToBeProxied, Cache<Object, Object> entityCache) {
        this.objectToBeProxied = objectToBeProxied;
        this.entityCache = entityCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InvocationKey invocationKey = new InvocationKey(method, args);
        Object result = entityCache.get(invocationKey);
        if (result == null) {
            result = method.invoke(objectToBeProxied, args);
            entityCache.put(invocationKey, result);
        }
        return result;
    }

    private class InvocationKey {

        private Method method;

        private Object[] args;

        InvocationKey(Method method, Object[] args) {
            this.method = method;
            this.args = args;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InvocationKey that = (InvocationKey) o;
            return (method != null ? method.equals(that.method) : that.method == null) && Arrays.equals(args, that.args);

        }

        @Override
        public int hashCode() {
            int result = method != null ? method.hashCode() : 0;
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }

}