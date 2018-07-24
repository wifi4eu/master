package wifi4eu.wifi4eu.service.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class UserService {
    private final Logger _log = LogManager.getLogger(UserService.class);

    @Value("${mail.server.location}")
    private String baseUrl;

    @Value("${ecas.location}")
    private String ecasUrl;

    public boolean isLocalHost() {
        return baseUrl.contains(UserConstants.LOCAL);
    }


}
