package ua.ithillel.exception;

public class DepartmentDaoException extends Exception {

    public DepartmentDaoException() {
    }

    public DepartmentDaoException(String message) {
        super(message);
    }

    public DepartmentDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentDaoException(Throwable cause) {
        super(cause);
    }
}
