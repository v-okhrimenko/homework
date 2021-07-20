package ua.ithillel.exeption;

public class EmployeeBusinessException extends Exception {

    public EmployeeBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBusinessException(String message) {
        super(message);

    }

    public EmployeeBusinessException(Throwable cause) {
        super(cause);
    }
}
