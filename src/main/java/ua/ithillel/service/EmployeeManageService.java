package ua.ithillel.service;

import ua.ithillel.dao.employee.EmployeeDao;
import ua.ithillel.dao.employee.EmployeeDaoFactory;
import ua.ithillel.exeption.EmployeeBusinessException;
import ua.ithillel.exeption.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.util.List;
import java.util.Objects;

public class EmployeeManageService {
    private final EmployeeDao employeeDao;

    public EmployeeManageService() {
        this.employeeDao = EmployeeDaoFactory.getInstance().getEmployeeDao();
    }

    public Long add(Employee employee) throws EmployeeBusinessException {
        // do some work to validate employee

        Long id = null;
        try {
            id = employeeDao.addEmployee(employee);
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
        return id;
    }

    private boolean checkEmployeeId(Long id) throws EmployeeBusinessException {
        return findAll().stream().anyMatch(e -> e.getId().equals(id));
    }

    public void delete(Long id) throws EmployeeBusinessException {
        if (checkEmployeeId(id)) {
            try {
                employeeDao.delete(id);
            } catch (EmployeeDaoException e) {
                throw new EmployeeBusinessException(e);
            }
        } else {
            System.out.println("Cant delete, id: " + id + " not found");
        }
    }

    public Employee get(Long id) throws EmployeeBusinessException {
        if (checkEmployeeId(id)) {
            try {
                return employeeDao.getEmployee(id);
            } catch (EmployeeDaoException e) {
                throw new EmployeeBusinessException(e);
            }
        } else {
            System.out.println("Employee with id: " + id + " not found");
            return null;
        }

    }

    public void update(Employee employee) throws EmployeeBusinessException {
        if (Objects.nonNull(employee)) {
            if (employee.getId() != null) {
                try {
                    employeeDao.update(employee);
                } catch (EmployeeDaoException e) {
                    throw new EmployeeBusinessException(e);
                }
                System.out.println("Employee " + employee.getId() + " updated successful");
            }
        } else {
            System.out.println("Cant update, employee not found");
        }

//        if (findAll().stream().anyMatch(e -> e.getId().equals(employee.getId())) & findAll().size() > 0) {

//            System.out.println("Employee " + employee.getId() + " updated successful");
//            return;
//        }
//        System.out.println("Cant update, employee not found");

    }

    public List<Employee> findAll() throws EmployeeBusinessException {
        try {
            return employeeDao.findEmployees();
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }

}
