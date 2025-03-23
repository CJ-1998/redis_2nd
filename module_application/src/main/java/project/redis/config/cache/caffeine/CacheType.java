package project.redis.config.cache.caffeine;

import lombok.Getter;

@Getter
public enum CacheType {

    MOVIE_CACHE("movieCache", 3600, 10000);

    private final String cacheName;
    private final Integer expireTimeInSeconds;
    private final Integer maxCachingSize;

    CacheType(String cacheName, Integer expireTimeInSeconds, Integer maxCachingSize) {
        this.cacheName = cacheName;
        this.expireTimeInSeconds = expireTimeInSeconds;
        this.maxCachingSize = maxCachingSize;
    }
}
