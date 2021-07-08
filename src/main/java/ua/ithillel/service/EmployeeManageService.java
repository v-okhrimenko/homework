package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeDaoFactory;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {
    private final EmployeeDao employeeDao;

    public EmployeeManageService() {
        this.employeeDao = EmployeeDaoFactory.getInstance().getEmployeeDao();
    }

    public Long add(Employee employee) {
        // do some work to validate employee

        Long id = employeeDao.addEmployee(employee);
        return id;
    }

    private boolean checkEmployeeId(Long id) {
        return findAll().stream().anyMatch(e -> e.getId().equals(id));
    }

    public void delete(Long id) {
        if (checkEmployeeId(id)) {
            employeeDao.delete(id);
        } else {
            System.out.println("Cant delete, id: " + id + " not found");
        }
    }

    public Employee get(Long id) {
        if (checkEmployeeId(id)) {
            return employeeDao.getEmployee(id);
        } else {
            System.out.println("Employee with id: " + id + " not found");
            return null;
        }

    }

    public void update(Employee employee) {

        if (findAll().stream().anyMatch(e -> e.getId().equals(employee.getId())) & findAll().size() > 0) {
            employeeDao.update(employee);
            System.out.println("Employee " + employee.getId() + " updated successful");
            return;
        }
        System.out.println("Cant update, employee not found");

    }

    public List<Employee> findAll() {
        return employeeDao.findEmployees();
    }

}
