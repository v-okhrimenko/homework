package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDaoFactory;
import ua.ithillel.dao.employee.EmployeeDao;
import ua.ithillel.exception.EmployeeBusinessException;
import ua.ithillel.exception.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {
    private final EmployeeDao employeeDao;

    public EmployeeManageService() {
        employeeDao = EmployeeDaoFactory.getInstance().getEmployeeDao();
    }

    public Long add(Employee employee) throws EmployeeBusinessException {
        try {
            // Do some validation work - проверка данных на правильность полей
            // Дополнительные действия — поиск сведений о контакте в социальных сетях, поиск через Google, ...
            // Бизнес-действие нередко включает несколько элементарных действий, среди которых будет и действия с хранилищем.
            return employeeDao.addEmployee(employee);
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }

    public void update(Employee employee) throws EmployeeBusinessException {
        try {
            // Do some additional work
            employeeDao.updateEmployee(employee);
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }

    public void delete(Long employeeId) throws EmployeeBusinessException {
        try {
            // Do some additional work
            employeeDao.deleteEmployee(employeeId);
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }

    public Employee get(Long employeeId) throws EmployeeBusinessException {
        try {
            // Do some additional work
            return employeeDao.getEmployee(employeeId);
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }

    public List<Employee> findAll() throws EmployeeBusinessException {
        try {
            // Do some additional work
            return employeeDao.findEmployees();
        } catch (EmployeeDaoException e) {
            throw new EmployeeBusinessException(e);
        }
    }
}
