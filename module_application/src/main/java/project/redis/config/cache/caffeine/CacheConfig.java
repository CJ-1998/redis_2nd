package project.redis.config.cache.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = Arrays.stream(CacheType.values())
                .map(cache -> new CaffeineCache(
                                cache.getCacheName(),
                                Caffeine.newBuilder()
                                        .expireAfterWrite(cache.getExpireTimeInSeconds(), TimeUnit.SECONDS)
                                        .maximumSize(cache.getMaxCachingSize())
                                        .recordStats()
                                        .build()
                        )
                )
                .toList();
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
