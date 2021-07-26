package ua.ithillel.service;

import ua.ithillel.dao.DepartmentDaoFactory;
import ua.ithillel.dao.department.DepartmentDao;
import ua.ithillel.exception.DepartmentBusinessException;
import ua.ithillel.exception.DepartmentDaoException;
import ua.ithillel.model.Department;

import java.util.List;

public class DepartmentManageService {
    private final DepartmentDao departmentDao;

    public DepartmentManageService() {
        this.departmentDao = DepartmentDaoFactory.getInstance().getDepartmentDao();
    }

    public Long add(Department department) throws DepartmentBusinessException {
        try {
            return departmentDao.addDepartment(department);
        } catch (DepartmentDaoException e) {
            throw new DepartmentBusinessException(e);
        }
    }

    public void delete(Long id) throws DepartmentBusinessException {
        try {
            departmentDao.delete(id);
        } catch (DepartmentDaoException e) {
            throw new DepartmentBusinessException(e);
        }
    }

    public Department get(Long id) throws DepartmentBusinessException {
        try {
            return departmentDao.getDepartment(id);
        } catch (DepartmentDaoException e) {
            throw new DepartmentBusinessException(e);
        }
    }

    public void update(Department department) throws DepartmentBusinessException {
        try {
            departmentDao.update(department);
        } catch (DepartmentDaoException e) {
            throw new DepartmentBusinessException(e);
        }
    }

    public List<Department> findAll() throws DepartmentBusinessException {
        try {
            return departmentDao.findDepartments();
        } catch (DepartmentDaoException e) {
            throw new DepartmentBusinessException(e);
        }
    }

}
