package ua.ithillel.dao;

import ua.ithillel.dao.employee.EmployeeDao;
import ua.ithillel.dao.employee.EmployeeDatabaseDao;

/**
 * EmployeeDaoFactory это сочетание фабрики и синглтона.
 * Обычно EmployeeDao - это синглтоны.
 */
public class EmployeeDaoFactory {

    private static EmployeeDaoFactory instance;
    private final EmployeeDao employeeDao = new EmployeeDatabaseDao();

    private EmployeeDaoFactory() {
    }

    public static synchronized EmployeeDaoFactory getInstance() {
        if (instance == null) {
            instance = new EmployeeDaoFactory();
        }
        return instance;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

//    public static EmployeeDao getEmployeeDao() {
//        return new EmployeeSimpleDao();
//    }
}
