package ua.ithillel.dao.employee;

import ua.ithillel.dbconnect.ConnectionBuilderFactory;
import ua.ithillel.dbconnect.DbConnectionBuilder;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.ithillel.util.AppConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {

    private static final String SELECT = "SELECT * FROM employee";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }


    @Override
    public Long addEmployee(Employee employee) {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee getEmployee(Long id) {
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
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findEmployees() {
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
            e.printStackTrace();
        }

        return null;
    }
}
