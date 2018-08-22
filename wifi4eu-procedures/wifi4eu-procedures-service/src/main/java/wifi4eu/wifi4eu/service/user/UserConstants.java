package wifi4eu.wifi4eu.service.user;

import eu.cec.digit.ecas.client.jaas.DetailedUser;

public class UserConstants {

    public final static int TIMEFRAME_ACTIVATE_ACCOUNT_HOURS = 2;
    public final static String RESET_PASS_URL = "forgot;token=";
    public final static String ACTIVATE_ACCOUNT_URL = "activation;token=";
    public final static String LOCAL = "localhost";
    public final static String DEFAULT_LANG = "en";

    /**
     *	Mocked user data used by the UserFilterMocked filter to login directly into the portal  
     */
    public final static String MOCKED_USER_NAME = "Mr. Tester";
    public final static String MOCKED_MAIL = "tester@test.com";
    public final static String MOCKED_DOMAIN = "TemporalDom";
    public final static DetailedUser MOCKED_DETAILED_USER = null;
    public final static String MOCKED_FIRST_NAME = "Tester Name 0 ";
    public final static String MOCKED_LAST_NAME = "Test LastName 0";
    public final static Long MOCKED_PER_ID = 1L;

}
