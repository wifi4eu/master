package wifi4eu.wifi4eu.common.exception.person;

import wifi4eu.wifi4eu.common.exception.AppException;

public class IdentityNotFoundException extends AppException {
    private static final long serialVersionUID = 7002262497864447271L;
    private String userName;
    private String employeeNumber;

    public IdentityNotFoundException(String message, String userName, Throwable e) {
        super(message, e);
        this.userName = userName;
        employeeNumber= null;
    }

    public IdentityNotFoundException(String message, String userName, String employeeNumber, Throwable e) {
        this(message, userName, e);
        this.employeeNumber = employeeNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String getCode() {
        return "app.exception.identityNotFoundException";
    }
}
