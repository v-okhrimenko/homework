package ua.ithillel.exception;

public class DepartmentBusinessException extends Exception {

    public DepartmentBusinessException() {
    }

    public DepartmentBusinessException(String message) {
        super(message);
    }

    public DepartmentBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentBusinessException(Throwable cause) {
        super(cause);
    }
}
