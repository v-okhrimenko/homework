package ua.ithillel.exeption;

public class EmployeeDaoException extends Exception {

    public EmployeeDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDaoException(String message) {
        super(message);

    }

    public EmployeeDaoException(Throwable cause) {
        super(cause);
    }
}
