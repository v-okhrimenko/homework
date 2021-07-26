package ua.ithillel.dao.employee;

import ua.ithillel.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSimpleDao implements EmployeeDao {

    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public Long addEmployee(Employee employee) {
        Long id = generateEmployeeId();
        employee.setId(id);
        employeeList.add(employee);
        return id;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee oldEmployee = getEmployee(employee.getId());
        if (Objects.nonNull(oldEmployee)) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setDepartmentId(employee.getDepartmentId());
            oldEmployee.setChiefId(employee.getChiefId());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Employee getEmployee(Long id) {
        for (Employee e : employeeList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
        // return employeeList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }

    private long generateEmployeeId() {
        long id = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while (getEmployee(id) != null) {
            id = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return id;
    }
}
