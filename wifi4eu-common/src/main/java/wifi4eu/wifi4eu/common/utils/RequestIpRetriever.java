package wifi4eu.wifi4eu.common.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestIpRetriever {

    public String getIp(HttpServletRequest request) {
        String ipAdd = request.getHeader("X-FORWARDED-FOR");
        if (ipAdd == null) {
            ipAdd = request.getRemoteAddr();
        }
        return ipAdd;
    }
}
