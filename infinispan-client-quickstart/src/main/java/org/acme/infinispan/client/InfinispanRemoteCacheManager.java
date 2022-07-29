package org.acme.infinispan.client;

import java.io.InputStream;
import java.util.Properties;


import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class InfinispanRemoteCacheManager
{
	private static InfinispanRemoteCacheManager instance;
	
	public static final InfinispanRemoteCacheManager getInstance() {
		return instance;
	}
	
	static {
		instance = new InfinispanRemoteCacheManager();
	}
	
	public RemoteCacheManager remoteCacheManager;
	
	private InfinispanRemoteCacheManager() 
	{
		init();
	}
	
	private void init() 
	{
        Properties prop = new Properties();
        try {
            InputStream stream = InfinispanRemoteCacheManager.class.getResourceAsStream("/hotrod-client.properties");
            
            prop.load(stream);
            stream.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.withProperties(prop);


        // Connect to the server
        remoteCacheManager = new RemoteCacheManager(builder.build());
	}
	
	public RemoteCacheManager getRemoteCacheManager() {
		return remoteCacheManager;
	}
}
