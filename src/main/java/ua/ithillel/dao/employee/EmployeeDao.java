package ua.ithillel.dao.employee;

import ua.ithillel.exeption.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Long addEmployee(Employee employee) throws EmployeeDaoException;

    void update(Employee employee) throws EmployeeDaoException;

    void delete(Long id) throws EmployeeDaoException;

    Employee getEmployee(Long id) throws EmployeeDaoException;

    List<Employee> findEmployees() throws EmployeeDaoException;
}
