package org.acme.infinispan.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class InfinispanClientApp {

    private static final Logger LOGGER = LoggerFactory.getLogger("InfinispanClientApp");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Create or get cache named mycache with the default configuration");
        RemoteCacheManager cacheManager = InfinispanRemoteCacheManager.getInstance().getRemoteCacheManager();
        RemoteCache<Object, Object> cache = cacheManager.getCache("jcache");
        cache.put("hello-hotrod-client", "Hello World, Infinispan is up!");
        cache.put("Infinispan", "Infinispan is up!");
    }
}
