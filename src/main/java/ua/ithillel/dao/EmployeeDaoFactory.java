package ua.ithillel.dao;

import java.util.Objects;

public class EmployeeDaoFactory {
    private static volatile EmployeeDaoFactory instance;
    private final EmployeeDao employeeDao;

    private EmployeeDaoFactory() {
        employeeDao = new EmployeeSimpleDao();
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
