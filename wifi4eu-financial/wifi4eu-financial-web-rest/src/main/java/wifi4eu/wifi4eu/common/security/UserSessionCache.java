package wifi4eu.wifi4eu.common.security;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;

import java.util.concurrent.TimeUnit;

@Service
public class UserSessionCache {

    private final static Long maxSize = 100L;
    private final static Long expirationMinutes = 5L;

    public LoadingCache<String, UserDTO> userSessionCache;

    public UserSessionCache() {
        this.userSessionCache = CacheBuilder.newBuilder()
                .maximumSize(maxSize)
                .expireAfterAccess(expirationMinutes, TimeUnit.MINUTES)
                .build(new CacheLoader<String, UserDTO>() {
                    @Override
                    public UserDTO load(String s) throws Exception {
                        return null;
                    }
                });
    }
}
