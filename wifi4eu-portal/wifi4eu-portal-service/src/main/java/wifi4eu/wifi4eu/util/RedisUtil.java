package wifi4eu.wifi4eu.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RedisRegistrationInfo;
import wifi4eu.wifi4eu.common.dto.model.RedisUserInfo;
import wifi4eu.wifi4eu.repository.user.UserRepository;

import java.util.List;

@Service
public class RedisUtil {

    private final Logger _log = LogManager.getLogger(RedisUtil.class);
    private final String channel = "refresh";

    private static RedisClient redis = null;
    private static int sentinelPort = 5000;

    private static final String sentinelUri1 = "10.0.2.31";
    private static final String sentinelUri2 = "10.0.2.32";
    private static final String sentinelUri3 = "10.0.2.33";

    @Autowired
    UserRepository userRepository;

    public RedisUtil() {
        RedisURI redisUri = RedisURI.Builder.sentinel(sentinelUri1, sentinelPort, "master1")
                .withSentinel(sentinelUri2, sentinelPort)
                .withSentinel(sentinelUri3, sentinelPort)
                .build();

        redis = RedisClient.create(redisUri);
    }

    public void sync(long userId) {
        RedisUserInfo userInfo = new RedisUserInfo();
        String message = "";

        List<Object[]> userInfoRows = (List<Object[]>) userRepository.updateRedisInfo(userId);
        for (Object[] item : userInfoRows) {
            userInfo.uid = (Integer) item[0];
            userInfo.Csrf = (String) item[1];
            RedisRegistrationInfo info = new RedisRegistrationInfo();
            info.MID = (Integer) item[4];
            info.Flag = (Integer) item[2];
            info.Docs = (Integer) item[5];

            userInfo.Registrations.put((Integer) item[3], info);
        }

        try {
            message = new ObjectMapper().writeValueAsString(userInfo);
            publish(message);
        } catch (Exception ex) {
            _log.error("MEH");
        }

        //publish("{\"uid\":28165,\"Csrf\":\"sFuN7r4SZOSuVdvepvrLD1fgr26r8ijc\",\"Registrations\":{\"22806\":{\"MID\":28532,\"Flag\":true,\"Docs\":true},\"22807\":{\"MID\":28533,\"Flag\":true,\"Docs\":true}}}");
    }


    private void publish(String message) {
        StatefulRedisConnection<String, String> sender = redis.connect();
        sender.sync().publish(this.channel, message);
    }
}
