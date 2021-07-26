package ua.ithillel.dao;

import ua.ithillel.dao.department.DepartmentDao;
import ua.ithillel.dao.department.DepartmentDatabaseDao;

import java.util.Objects;

public class DepartmentDaoFactory {
    private static volatile DepartmentDaoFactory instance;
    private final DepartmentDao departmentDao = new DepartmentDatabaseDao();

    private DepartmentDaoFactory() {
    }

    public static synchronized DepartmentDaoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DepartmentDaoFactory();
        }
        return instance;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }
}
