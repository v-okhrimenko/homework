package ua.ithillel.exception;

public class EmployeeDaoException extends Exception {

    public EmployeeDaoException() {
    }

    public EmployeeDaoException(String message) {
        super(message);
    }

    public EmployeeDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDaoException(Throwable cause) {
        super(cause);
    }
}
