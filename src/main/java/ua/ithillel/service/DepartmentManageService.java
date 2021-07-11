package ua.ithillel.service;

import ua.ithillel.dao.department.DepartmentDao;
import ua.ithillel.dao.department.DepartmentDaoFactory;
import ua.ithillel.model.Department;

import java.util.List;
import java.util.Objects;

public class DepartmentManageService {
    private final DepartmentDao departmentDao;

    public DepartmentManageService() {
        this.departmentDao = DepartmentDaoFactory.getInstance().getDepartmentDao();
    }

    public Long add(Department department) {
        Long id = departmentDao.addDepartment(department);
        return id;
    }

    private boolean checkDepartmentId(Long id) {
        return findAll().stream().anyMatch(e -> e.getId().equals(id));
    }

    public void delete(Long id) {
        if (checkDepartmentId(id)) {
            departmentDao.delete(id);
        } else {
            System.out.println("Cant delete, id: " + id + " not found");
        }
    }

    public Department get(Long id) {
        if (checkDepartmentId(id)) {
            return departmentDao.getDepartment(id);
        } else {
            System.out.println("Department with id: " + id + " not found");
            return null;
        }

    }

    public void update(Department department) {
        if (Objects.nonNull(department)) {
            if (department.getId() != null) {
                departmentDao.update(department);
                System.out.println("department " + department.getId() + " updated successful");
            } else {
                System.out.println("Cant update, department id cant be NULL");
            }
        } else {
            System.out.println("Cant update, department not found");
        }
    }

    public List<Department> findAll() {
        return departmentDao.findDepartments();
    }

}
