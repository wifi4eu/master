package edcchelpdesk.getrequest.utils;

import edcchelpdesk.getrequest.Constants;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    public static Map<String, String> generateHeaders() {
        Map<String, String> headers = new HashMap<>();

        headers.put(Constants.HEADER_USER_AGENT, Constants.HEADER_USER_AGENT_VALUE);
        headers.put(Constants.HEADER_ACCEPT, Constants.HEADER_ACCEPT_VALUE);
        headers.put(Constants.HEADER_AUTH, Constants.HEADER_AUTH_VALUE);

        return headers;
    }

}
