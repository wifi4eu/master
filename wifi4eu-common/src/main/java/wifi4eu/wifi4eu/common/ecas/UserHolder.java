package wifi4eu.wifi4eu.common.ecas;

import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import org.apache.commons.lang.StringUtils;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;


public class UserHolder {

    private static final ThreadLocal<UserContext> userHolder = new ThreadLocal<UserContext>();

    public static void clearUser() {
        userHolder.remove();
    }

    public static UserContext getUser() {
        return userHolder.get();
    }

    public static void setUser(UserContext userContext) {

        userHolder.set(userContext);
    }
    
    public static DetailedUser getDetailedUser() {
        try {
            return SubjectUtil.getCurrentEcasUser();
        } catch (SubjectNotFoundException e) {
            throw new AppException("No ECAS detail user", e);
        }
    }

    public static Long extractEcasEmployeeNumber(DetailedUser detailedUser) {
        String employeeNumber = detailedUser.getEmployeeNumber();

        try {
            return StringUtils.isEmpty(employeeNumber)? null:Long.valueOf(employeeNumber);
        } catch (NumberFormatException e) {
            throw new AppException("ECAS detail user employeeNumber NOT numeric '" + employeeNumber + "' for user " + detailedUser.getName(), e);
        }
    }
}
