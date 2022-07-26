package org.acme.infinispan.client;

import javax.cache.Cache;
import javax.cache.CacheManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/infinispan")
public class InfinispanGreetingResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	CacheManager cacheManager = InfinispanRemoteJCacheManager.getInstance().getCacheManager();
	    Cache<String, String> cache = cacheManager.getCache("jcache");
        return cache.get("hello");
    }
}
