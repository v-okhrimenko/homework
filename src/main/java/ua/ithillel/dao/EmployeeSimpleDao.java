package ua.ithillel.dao;

import ua.ithillel.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSimpleDao implements EmployeeDao {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public Long addEmployee(Employee employee) {
        if (Objects.nonNull(employee)) {
            long employeeId = getEmployeeId();
            employee.setId(employeeId);
            employeeList.add(employee);
            return employeeId;
        }
        return -1L;
    }

    private long getEmployeeId() {
        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        while (Objects.nonNull(getEmployee(id))) {
            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        }
        return id;
    }

    @Override
    public void update(Employee employee) {
        if (employeeList.size() > 0) {
            employeeList.set(employeeList.indexOf(employee), employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }
}
