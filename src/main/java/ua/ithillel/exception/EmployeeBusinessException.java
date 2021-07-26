package ua.ithillel.exception;

public class EmployeeBusinessException extends Exception {

    public EmployeeBusinessException() {
    }

    public EmployeeBusinessException(String message) {
        super(message);
    }

    public EmployeeBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBusinessException(Throwable cause) {
        super(cause);
    }
}
