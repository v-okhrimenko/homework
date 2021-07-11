package ua.ithillel.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.ithillel.dao.employee.EmployeeSimpleDao;
import ua.ithillel.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeSimpleDaoTest {

    private EmployeeSimpleDao employeeSimpleDao;

    @Test
    void addEmployeeNull() {
        employeeSimpleDao = new EmployeeSimpleDao();
        employeeSimpleDao.addEmployee(null);
        assertEquals(0, employeeSimpleDao.findEmployees().size());
    }

    @Test
    void addEmployee() {
        employeeSimpleDao = new EmployeeSimpleDao();
        assertEquals(0, employeeSimpleDao.findEmployees().size());
        employeeSimpleDao.addEmployee(new Employee("Харитонов Петр Зигмундович", 10000, 1L, null));
        assertEquals(1, employeeSimpleDao.findEmployees().size());
        employeeSimpleDao.addEmployee(new Employee("Холодная Зинаида Брунгильдовна", 10300, 2L, null));
        assertEquals(2, employeeSimpleDao.findEmployees().size());
    }


    @Test
    void update() {
        employeeSimpleDao = new EmployeeSimpleDao();
        Long idForUpdate = employeeSimpleDao.addEmployee(new Employee("Мутный Семен Викторович", 10300, 2L, null));
        assertEquals("Мутный Семен Викторович", employeeSimpleDao.getEmployee(idForUpdate).getName());
        Employee e = employeeSimpleDao.getEmployee(idForUpdate);
        e.setName("Чистый Петр Ефимович");
        e.setSalary(3000);
        employeeSimpleDao.update(e);
        assertEquals("Чистый Петр Ефимович", employeeSimpleDao.getEmployee(idForUpdate).getName());
        assertEquals(3000, employeeSimpleDao.getEmployee(idForUpdate).getSalary());
    }

    @Test
    void updateNotPresentEmployee() {
        employeeSimpleDao = new EmployeeSimpleDao();
        Employee employee = new Employee("Новый Яков Германови", 12345, 4L, null);
        employeeSimpleDao.update(employee);
        assertEquals(0, employeeSimpleDao.findEmployees().size());
    }

    @Test
    void delete() {
        employeeSimpleDao = new EmployeeSimpleDao();
        Long e1Id = employeeSimpleDao.addEmployee(new Employee("Мутный Семен Викторович", 10300, 2L, null));
        assertEquals(1, employeeSimpleDao.findEmployees().size());
        employeeSimpleDao.delete(e1Id);
        assertEquals(0, employeeSimpleDao.findEmployees().size());
    }

    @Test
    void deleteWrongId() {
        employeeSimpleDao = new EmployeeSimpleDao();
        employeeSimpleDao.delete(123L);
        assertEquals(0, employeeSimpleDao.findEmployees().size());
    }


    @Test
    void getEmployee() {
        employeeSimpleDao = new EmployeeSimpleDao();
        employeeSimpleDao.addEmployee(new Employee("Харитонов Петр Зигмундович", 10000, 1L, null));
        Long e2Id = employeeSimpleDao.addEmployee(new Employee("Холодная Зинаида Брунгильдовна", 10300, 2L, null));
        Employee getEmployee = employeeSimpleDao.getEmployee(e2Id);
        assertEquals("Холодная Зинаида Брунгильдовна", getEmployee.getName());
    }

    @Test
    void getEmployeeWrongId() {
        employeeSimpleDao = new EmployeeSimpleDao();
        employeeSimpleDao.addEmployee(new Employee("Харитонов Петр Зигмундович", 10000, 1L, null));
        employeeSimpleDao.addEmployee(new Employee("Холодная Зинаида Брунгильдовна", 10300, 2L, null));
        Assertions.assertNull(employeeSimpleDao.getEmployee(123L));
        Assertions.assertNull(employeeSimpleDao.getEmployee(null));
    }

    @Test
    void findEmployees() {
        employeeSimpleDao = new EmployeeSimpleDao();
        Employee e1 = new Employee("Назаров Максим Давидович", 35000, 1L, null);
        Long e1Id = employeeSimpleDao.addEmployee(e1);
        Employee e2 = new Employee("Александрова Аиша Игорьевна", 5000, 1L, e1Id);
        employeeSimpleDao.addEmployee(e2);
        Employee e3 = new Employee("Кузьмин Артем Богданович", 5500, 1L, e1Id);
        employeeSimpleDao.addEmployee(e3);
        assertEquals(3, employeeSimpleDao.findEmployees().size());
    }
}