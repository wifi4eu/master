package wifi4eu.wifi4eu.common.exception;

public class NotFoundException extends AppException {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String employeeNumber;

    public NotFoundException(String message, Throwable e) {
        super(message, e);
    }

    @Override
    public String getCode() {
        return "app.exception.notFoundException";
    }
}

