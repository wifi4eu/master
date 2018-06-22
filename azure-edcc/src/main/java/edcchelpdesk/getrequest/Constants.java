package edcchelpdesk.getrequest;

public class Constants {

    private static final String BASE_URL     = "http://wifi4eu.everisdigitalchannels.com:8080/wifi4eu-edcc";
    public static final String URL_GET_TOKEN = BASE_URL + "/oauth/token?grant_type=password&username=wififoreu_public_user&password=q27Dz38WESBeYE9BX6PrySfH";
    public static final String URL_CALL_EDCC = BASE_URL + "/edcc/helpdesk/?access_token=";

    public static final String GET = "GET";
    public static final String POST = "POST";

    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_USER_AGENT_VALUE = "Mozilla/5.0";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_VALUE = "application/json";
    public static final String HEADER_AUTH = "Authorization";
    public static final String HEADER_AUTH_VALUE = "Basic bXktd2lmaTRldS1zZWN1cmVkLXRydXN0ZWQtY2xpZW50OkBwflJ7LmJycjItP3tuIT0/SH5XVXhSPU0oTHNRRmJEazt1OmFmIjZCYnJiRGA+M0xMcVI8OHI6TStzYStDZCl3WmVLQEtnTXhHPy9SU1ohZTlbcW5HTS8nPSNLLURkQS4zVURue0JjNChkWVdWfTVIYWgiJCNDIT9GLn5QSGA4";

}
