package wifi4eu.wifi4eu.common.dto.model;

import java.util.HashMap;
import java.util.Map;

public class RedisUserInfo {

    public Integer uid;
    public String Csrf;
    public Map<Integer, RedisRegistrationInfo> Registrations;

    public RedisUserInfo() {
        this.Registrations = new HashMap<Integer, RedisRegistrationInfo>();
    }
}
