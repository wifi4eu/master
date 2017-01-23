package wifi4eu.wifi4eu.common.ecas;

import wifi4eu.wifi4eu.common.security.UserContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wifi4eu.wifi4eu.common.exception.person.IdentityNotFoundException;
import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;


public class UserHolder {
    private final static Logger logger = LoggerFactory.getLogger(UserHolder.class);

    private static final ThreadLocal<UserContext> userHolder = new ThreadLocal<UserContext>();

    public static void clearUser() {
        logger.debug("clearUser");
        userHolder.remove();
    }

    public static UserContext getUser() {
        return userHolder.get();
    }

    public static void setUser(UserContext userContext) {
        if (logger.isDebugEnabled()) {
            logger.debug("setUser: {}", userContext.getLogin());
        }
        userHolder.set(userContext);
    }
    
    public static DetailedUser getDetailedUser() {
        try {
            return SubjectUtil.getCurrentEcasUser();
        } catch (SubjectNotFoundException e) {
            throw new IdentityNotFoundException("No ECAS DetailedUser", "Unknown", e);
        }
    }

    public static Long extractEcasEmployeeNumber(DetailedUser detailedUser) {
        String employeeNumber = detailedUser.getEmployeeNumber();

        try {
            return StringUtils.isEmpty(employeeNumber)? null:Long.valueOf(employeeNumber);
        } catch (NumberFormatException e) {
            throw new IdentityNotFoundException("ECAS DetailedUser employeeNumber NOT Numeric: ", employeeNumber, detailedUser.getName(), e);
        }
    }    

}
