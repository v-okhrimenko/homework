package ua.ithillel.dao.department;

import ua.ithillel.dbconnect.ConnectionBuilderFactory;
import ua.ithillel.dbconnect.DbConnectionBuilder;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.ithillel.util.AppConstant.COLUMN_ID;
import static ua.ithillel.util.AppConstant.COLUMN_NAME;

public class DepartmentDatabaseDao implements DepartmentDao {

    private static final String SELECT = "SELECT * FROM department";
    private static final String SELECT_ONE = "SELECT * FROM department WHERE id = ?";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long addDepartment(Department department) {
        return null;
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Department getDepartment(Long id) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(SELECT_ONE);
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Department(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findDepartments() {
        List<Department> departmentList = new ArrayList<>();
        try (
                Connection con = getConnection();
                Statement stmt = con.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Department department = new Department(
                        rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME)
                );
                departmentList.add(department);
            }
            return departmentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
