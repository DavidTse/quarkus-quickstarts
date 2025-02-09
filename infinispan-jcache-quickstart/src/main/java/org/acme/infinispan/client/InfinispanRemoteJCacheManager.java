package org.acme.infinispan.client;

import java.net.URI;

import javax.cache.CacheManager;
import javax.cache.Caching;

public class InfinispanRemoteJCacheManager
{
	private static InfinispanRemoteJCacheManager instance;
	
	public static final String PROVIDER = "org.infinispan.jcache.remote.JCachingProvider";
	
	public static final InfinispanRemoteJCacheManager getInstance() {
		return instance;
	}
	
	public CacheManager cacheManager;
	
	static {
		instance = new InfinispanRemoteJCacheManager();
	}
	
	private InfinispanRemoteJCacheManager() 
	{
		init();
	}
	
	private void init() 
	{
		URI uri = URI.create("application.properties");
	    cacheManager = Caching.getCachingProvider(PROVIDER)
          .getCacheManager(uri, InfinispanRemoteJCacheManager.class.getClass().getClassLoader());
	}
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}
}
