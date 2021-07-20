package ua.ithillel.dao.employee;

import ua.ithillel.dbconnect.ConnectionBuilderFactory;
import ua.ithillel.dbconnect.DbConnectionBuilder;
import ua.ithillel.exeption.EmployeeDaoException;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {

    private static final String SELECT = "SELECT * FROM employee";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private static final String INSERT = "INSERT INTO employee (name, salary, department_id, chief_id) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }


    @Override
    public Long addEmployee(Employee employee) throws EmployeeDaoException {
        long employeeId = -1;
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT, new String[]{COLUMN_ID}); // Statment.RETURN_GENERATED_KEYS
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
            ResultSet resultSet = stmt.getGeneratedKeys();
            while (resultSet.next()) {
                employeeId = resultSet.getLong(COLUMN_ID);
            }
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
        return employeeId;
    }

    @Override
    public void update(Employee employee) throws EmployeeDaoException {
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

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws EmployeeDaoException {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(DELETE);
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
    }

    @Override
    public Employee getEmployee(Long id) throws EmployeeDaoException {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SELECT_ONE);
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Long chiefId = rs.getLong(COLUMN_CHIEF_ID);
                if (rs.wasNull()) {
                    chiefId = null;
                }
                return new Employee(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chiefId
                );
            }
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
        return null;
    }

    @Override
    public List<Employee> findEmployees() throws EmployeeDaoException {
        List<Employee> employeeList = new ArrayList<>();
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
                Employee employee = new Employee(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chiefId
                );
                employeeList.add(employee);
            }
            return employeeList;
        } catch (SQLException e) {
            throw new EmployeeDaoException(e);
        }
    }
}
