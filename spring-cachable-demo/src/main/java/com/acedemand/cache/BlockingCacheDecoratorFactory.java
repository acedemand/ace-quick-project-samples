package com.acedemand.cache;

/**
 * Created by Pamir on 6/1/2015.
 */
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.constructs.CacheDecoratorFactory;
import net.sf.ehcache.constructs.blocking.BlockingCache;

import java.util.Properties;

/**
 * Used in the ehcache configuration to create {@link net.sf.ehcache.constructs.blocking.BlockingCache}s. This
 * avoids a thundering herds situation when a heavily trafficed cached object expires (i.e., the configuration).
 */
public class BlockingCacheDecoratorFactory extends CacheDecoratorFactory {

    private static final int TIMEOUT_MILLIS = 1000;

    @Override
    public Ehcache createDecoratedEhcache(final Ehcache cache, final Properties properties) {
        final BlockingCache blockingCache = new BlockingCache(cache);
        blockingCache.setTimeoutMillis(TIMEOUT_MILLIS);
        return blockingCache;
    }

    @Override
    public Ehcache createDefaultDecoratedEhcache(final Ehcache cache, final Properties properties) {
        return this.createDecoratedEhcache(cache, properties);
    }
}
