package ua.ithillel.dao.employee;

import java.util.Objects;

public class EmployeeDaoFactory {
    private static volatile EmployeeDaoFactory instance;
    private final EmployeeDao employeeDao;

    private EmployeeDaoFactory() {

        //employeeDao = new EmployeeSimpleDao();
        employeeDao = new EmployeeDatabaseDao();
    }

    public static synchronized EmployeeDaoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EmployeeDaoFactory();
        }
        return instance;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
