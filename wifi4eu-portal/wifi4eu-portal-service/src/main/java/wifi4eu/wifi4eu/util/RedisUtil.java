package wifi4eu.wifi4eu.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RedisRegistrationInfo;
import wifi4eu.wifi4eu.common.dto.model.RedisUserInfo;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.repository.user.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:redis.properties")
@Service
public class RedisUtil {

    @Value("${redis.sentinel.uris}")
    private String[] redisUris;

    @Value("${redis.enabled}")
    private boolean enableSync = true;

    private final Logger _log = LogManager.getLogger(RedisUtil.class);
    private final String channel = "refresh";

    private static RedisClient redis = null;
    private static int sentinelPort = 5000;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        if (this.enableSync) {
            if (Validator.isNotNull(this.redisUris) && this.redisUris.length == 3) {
                RedisURI redisUri = RedisURI.Builder.sentinel(this.redisUris[0], sentinelPort, "master1")
                        .withSentinel(this.redisUris[1], sentinelPort)
                        .withSentinel(this.redisUris[2], sentinelPort)
                        .build();
                redis = RedisClient.create(redisUri);
                _log.info("***************** REDIS ******************************");
                _log.info(" > Hosts: " + Arrays.toString(this.redisUris));
                _log.info("         -    REDIS INITIALIZED     -                  ");
                _log.info("******************************************************");
            } else {
                _log.info("***************** REDIS ******************************");
                _log.info(" > REDIS SYNC URIs NOT SETS");
                _log.info("******************************************************");
            }

        } else {
            _log.info("***************** REDIS ******************************");
            _log.info(" > REDIS SYNC IS DISABLED");
            _log.info("******************************************************");
        }
    }

    public RedisUtil() { }

    public void sync(long userId) {
        if (!this.enableSync || Validator.isNull(redis)) {
            return;
        }

        _log.info("[REDIS PUB/SUB] Initializing sync for user " + userId);
        RedisUserInfo userInfo = new RedisUserInfo();

        List<Object[]> userInfoRows = (List<Object[]>) userRepository.updateRedisInfo(userId);
        if (Validator.isNotNull(userInfoRows) && !userInfoRows.isEmpty()) {
            for (Object[] item : userInfoRows) {
                userInfo.uid = (Integer) item[0];
                userInfo.Csrf = (String) item[1];
                RedisRegistrationInfo info = new RedisRegistrationInfo();
                info.MID = (Integer) item[4];
                info.Flag = (Boolean) item[2];
                info.Docs = (Boolean) item[5];

                userInfo.Registrations.put((Integer) item[3], info);
            }

        } else {
            User user = userRepository.findOne((int) userId);
            userInfo.uid = user.getId();
            userInfo.Csrf = user.getCsrfToken();
        }

        try {
            String message = new ObjectMapper().writeValueAsString(userInfo);
            _log.info("[REDIS PUB/SUB] Publish: " + message);
            publish(message);
        } catch (Exception ex) {
            _log.error("[REDIS PUB/SUB] [ERROR] - Could not serialize object and publish message");
        }

        _log.info("[REDIS PUB/SUB] Finished sync for user " + userId);
    }


    private void publish(String message) {
        StatefulRedisConnection<String, String> sender = redis.connect();
        sender.sync().publish(this.channel, message);
        sender.close();
    }
}
