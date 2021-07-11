package ua.ithillel.dao.department;

import ua.ithillel.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentSimpleDao implements DepartmentDao {
    private final List<Department> departmentsList = new ArrayList<>();

    @Override
    public Long addDepartment(Department department) {
        if (Objects.nonNull(department)) {
            long departmentId = getDepartmentId();
            department.setId(departmentId);
            departmentsList.add(department);
            return departmentId;
        }
        return -1L;
    }

    private long getDepartmentId() {
        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        while (Objects.nonNull(getDepartment(id))) {
            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        }
        return id;
    }

    @Override
    public void update(Department department) {
        Department oldDepartment = getDepartment(department.getId());
        if (Objects.nonNull(oldDepartment)) {
            if (oldDepartment.getId() != null) {
                oldDepartment.setName(department.getName());
            }
        }
    }

    @Override
    public void delete(Long id) {
        departmentsList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentsList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Department> findDepartments() {
        return departmentsList;
    }
}
