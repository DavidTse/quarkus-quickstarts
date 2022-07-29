package org.acme.infinispan.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;


@Path("/infinispan")
public class InfinispanGreetingResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	RemoteCacheManager cacheManager = InfinispanRemoteCacheManager.getInstance().getRemoteCacheManager();
    	RemoteCache<String, String> cache = cacheManager.getCache("jcache");

        return cache.get("hello-hotrod-client");
    }
}
