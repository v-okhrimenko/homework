package ua.ithillel.dao.employee;

import ua.ithillel.dbconnection.ConnectionBuilderFactory;
import ua.ithillel.dbconnection.DbConnectionBuilder;
import ua.ithillel.exception.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.DbConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {

    private static final String INSERT = "INSERT INTO employee(name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private static final String SELECT = "SELECT * FROM employee";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";

    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getInstance().getDbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long addEmployee(Employee employee) throws EmployeeDaoException {
        // Здесь формируются запросы, используя или
        // Statement, PreparedStatement, CallableStatement
        // Из ResultSet создаем экземпляр UserDTO и заполняем его данными

        // Объявили переменную для хранения ИД
        long employeeId = -1L;

        // Вторым параметром prepareStatement передаем массив полей, значения которых нам нужны
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT, new String[]{COLUMN_ID})
        ) {
            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getSalary());
            stmt.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                stmt.setNull(4, Types.NULL);
            } else {
                stmt.setLong(4, employee.getChiefId());
            }
            stmt.executeUpdate();

            // Получаем список данных дял сгенерированных ключей
            ResultSet gk = stmt.getGeneratedKeys();
            if (gk.next()) {
                // Получаем поле id
                employeeId = gk.getLong("id");
            }
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
        return employeeId;
    }

    @Override
    public void updateEmployee(Employee employee) throws EmployeeDaoException {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(UPDATE);
        ) {
            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getSalary());
            stmt.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                stmt.setNull(4, Types.NULL);
            } else {
                stmt.setLong(4, employee.getChiefId());
            }
            stmt.setLong(5, employee.getId());

            int i = stmt.executeUpdate();
            System.out.println("Updated " + i + " rows");
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
    }

    @Override
    public void deleteEmployee(Long id) throws EmployeeDaoException {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(DELETE)
        ) {
            stmt.setLong(1, id);
            int i = stmt.executeUpdate();
            System.out.println("Deleted " + i + " rows");
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
    }

    @Override
    public Employee getEmployee(Long id) throws EmployeeDaoException {
        Employee employee = null;
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SELECT_ONE)
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long chiefId = rs.getLong(COLUMN_CHIEF_ID);
                if (rs.wasNull()) {
                    chiefId = null;
                }
                employee = new Employee(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chiefId);
            }
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployees() throws EmployeeDaoException {
        ArrayList<Employee> employees = new ArrayList<>();
        try (
                Connection con = getConnection();
                Statement stmt = con.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Long chiefId = rs.getLong(COLUMN_CHIEF_ID);
                if (rs.wasNull()) {
                    chiefId = null;
                }
                Employee em = new Employee(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chiefId);
                employees.add(em);
            }
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
        return employees;
    }
}
