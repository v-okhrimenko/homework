package ua.ithillel.dao.department;

import ua.ithillel.model.Department;

import java.util.List;

public interface DepartmentDao {

    Long addDepartment(Department department);

    void update(Department department);

    void delete(Long id);

    Department getDepartment(Long id);

    List<Department> findDepartments();
}
