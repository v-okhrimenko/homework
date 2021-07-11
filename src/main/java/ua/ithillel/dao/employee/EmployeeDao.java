package ua.ithillel.dao.employee;

import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Long addEmployee(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee getEmployee(Long id);

    List<Employee> findEmployees();
}
