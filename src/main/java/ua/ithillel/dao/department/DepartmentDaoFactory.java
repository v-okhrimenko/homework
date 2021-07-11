package ua.ithillel.dao.department;

import java.util.Objects;

public class DepartmentDaoFactory {
    private static volatile DepartmentDaoFactory instance;
    private final DepartmentDao departmentDao;

    private DepartmentDaoFactory() {

        //departmentDao = new DepartmentSimpleDao();
        departmentDao = new DepartmentDatabaseDao();
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
