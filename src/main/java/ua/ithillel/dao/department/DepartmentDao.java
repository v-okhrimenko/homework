package ua.ithillel.dao.department;

import ua.ithillel.exception.DepartmentDaoException;
import ua.ithillel.model.Department;

import java.util.List;

public interface DepartmentDao {

    Long addDepartment(Department department) throws DepartmentDaoException;

    void update(Department department) throws DepartmentDaoException;

    void delete(Long id) throws DepartmentDaoException;

    Department getDepartment(Long id) throws DepartmentDaoException;

    List<Department> findDepartments() throws DepartmentDaoException;
}
