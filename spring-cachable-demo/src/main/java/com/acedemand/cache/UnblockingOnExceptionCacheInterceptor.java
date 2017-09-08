package com.acedemand.cache;

/**
 * Created by Pamir on 6/1/2015.
 */

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.CacheOperation;
import org.springframework.cache.interceptor.CacheOperationInvoker;
import org.springframework.cache.interceptor.CacheResolver;

import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Useful in combination with a {@link net.sf.ehcache.constructs.blocking.BlockingCache}. When the intercepted method
 * call fails, removes the lock created during the get() operation so other threads can try again.
 */
public class UnblockingOnExceptionCacheInterceptor extends CacheInterceptor {

    @Autowired
    private CacheResolver cacheResolver;

    @Override
    protected Object execute(final CacheOperationInvoker invoker, final Object target, final Method method, final Object[] args) {
        try {
            return super.execute(invoker, target, method, args);
        } catch (Exception e) {
            // get backing class
            Class<?> targetClass = AopProxyUtils.ultimateTargetClass(target);
            if (targetClass == null && target != null) {
                targetClass = target.getClass();
            }

            final Collection<CacheOperation> cacheOps = getCacheOperationSource().getCacheOperations(method, targetClass);
            for (final CacheOperation cacheOp : cacheOps) {
                for (final Cache c : this.getCaches(this.getOperationContext(cacheOp, method, args, target, targetClass), cacheResolver)) {
                    c.put(cacheOp.getKey(), null);
                }
            }
            throw e;
        }
    }
}
