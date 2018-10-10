package wifi4eu.wifi4eu.web.cnect.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// TODO: remove duplicated XML or Annotation-based configuration
@EnableCaching
@Configuration
@ComponentScan(basePackages = {"wifi4eu.wifi4eu.service", "wifi4eu.wifi4eu.web.util.authorisation"})
@EnableAspectJAutoProxy
public class AppConfig {

    //EhCache based CacheManager, most commonly used in Enterprise applications.
    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(this.ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        return factory;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
    	ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
    	// The pool of threads can be configured here
		//pool.setCorePoolSize(5);
		//pool.setMaxPoolSize(10);
		//pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
    }
    
    @Bean
    public SyncTaskExecutor syncTaskExecutor() {
    	return new SyncTaskExecutor();
    }

}