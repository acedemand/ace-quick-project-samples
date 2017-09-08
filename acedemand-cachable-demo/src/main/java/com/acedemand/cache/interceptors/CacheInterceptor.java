package com.acedemand.cache.interceptors;

import com.acedemand.cache.annotations.Cacheable;
import com.acedemand.cache.wrappers.ICacheWrapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
@Aspect
public class CacheInterceptor {

    private ICacheWrapper cacheWrapper;

    public CacheInterceptor(ICacheWrapper cacheWrapper) {
        this.cacheWrapper = cacheWrapper;
    }

    @Around("@annotation(com.acedemand.cache.annotations.Cacheable)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("proceedingJoinPoint.getStaticPart().getSignature() = " + proceedingJoinPoint.getStaticPart().getSignature());


        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[] annotations = proceedingJoinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getAnnotations();
        String cacheName = "";
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Cacheable.class)) {
                cacheName = ((Cacheable) annotation).value();
            }
        }
        Object result = cacheWrapper.get(cacheName, methodName);
        if(result == null){
            result = proceedingJoinPoint.proceed();
        }
        cacheWrapper.put(cacheName,methodName,result);
        return result;

    }
}
