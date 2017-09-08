package com.acedemand.cache.wrappers;

import net.sf.ehcache.Element;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
public interface ICacheWrapper {
    public Object get(String cacheKey, String key);

    public void put(String cacheKey, String key, Object result) ;
}
