package com.acedemand.cache.wrappers;


import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
public class EhCacheWrapper implements ICacheWrapper {
    private CacheManager cacheManager;

    public EhCacheWrapper(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public Object get(String cacheKey, String key) {
        Element element = cacheManager.getCache(cacheKey).get(key);
        return element == null ? null: element.getObjectValue();
    }

    public void put(String cacheKey, String key, Object result) {
        this.cacheManager.getCache(cacheKey).put(new Element(key, result));
    }
}
