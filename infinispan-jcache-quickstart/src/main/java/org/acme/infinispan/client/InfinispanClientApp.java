package org.acme.infinispan.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class InfinispanClientApp {

    private static final Logger LOGGER = LoggerFactory.getLogger("InfinispanClientApp");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Create or get cache named mycache with the default configuration");
    	CacheManager cacheManager = InfinispanRemoteJCacheManager.getInstance().getCacheManager();
	    Cache<String, String> cache = cacheManager.getCache("jcache");
        cache.put("hello", "Hello World, Infinispan is up!");
        cache.put("key", "value");
        cache.put("pi", "3.14159265384");
    }
}
