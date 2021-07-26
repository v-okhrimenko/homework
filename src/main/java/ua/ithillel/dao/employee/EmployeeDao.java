package ua.ithillel.dao.employee;

import ua.ithillel.exception.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Long addEmployee(Employee employee) throws EmployeeDaoException;

    void updateEmployee(Employee employee) throws EmployeeDaoException;

    void deleteEmployee(Long id) throws EmployeeDaoException;

    Employee getEmployee(Long id) throws EmployeeDaoException;

    List<Employee> findEmployees() throws EmployeeDaoException;
}
