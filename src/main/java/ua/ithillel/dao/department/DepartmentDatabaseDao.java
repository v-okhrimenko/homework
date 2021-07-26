package ua.ithillel.dao.department;

import ua.ithillel.dbconnection.ConnectionBuilderFactory;
import ua.ithillel.dbconnection.DbConnectionBuilder;
import ua.ithillel.exception.DepartmentDaoException;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.DbConstant.COLUMN_ID;
import static ua.ithillel.util.DbConstant.COLUMN_NAME;

public class DepartmentDatabaseDao implements DepartmentDao {

    private static final String SELECT = "SELECT * FROM department";

    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getInstance().getDbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long addDepartment(Department department) {
        // function adddepartment:
        /*
        begin
        INSERT INTO department (name)
        SELECT  new_dep_name
        WHERE   new_dep_name NOT IN ( SELECT  name FROM department);
		SELECT id into new_dep_id from department where name = new_dep_name;
        end;
         */

        long id = -1L;
        try (
                Connection con = getConnection();
                CallableStatement stmt = con.prepareCall("{call adddepartment(?,?)}");
        ) {
            stmt.setString(1, department.getName());
            stmt.registerOutParameter(2, Types.BIGINT);

            stmt.execute();
            id = (long) stmt.getObject(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    // function updatedepartment:
    /*
    begin
    UPDATE department SET name = dep_new_name
    WHERE id = dep_id;
    result = TRUE;
    end;
     */

    public void update(Department department) {
        if (Objects.isNull(department)) {
            System.out.println("Department NULL");
        } else if (department.getId() == null) {
            System.out.println("Department ID is NULL");
        } else {
            try (
                    Connection con = getConnection();
                    CallableStatement stmt = con.prepareCall("{call updatedepartment(?,?,?)}");
            ) {
                stmt.setLong(1, department.getId());
                stmt.registerOutParameter(3, Types.BOOLEAN);
                stmt.setString(2, department.getName());
                stmt.execute();
                System.out.println("department " + department.getId() + " updated: " + stmt.getBoolean(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    // function deletedepartmentbyid:
    /*
    begin
    DELETE FROM department WHERE department.id = department_id;
    end;
    */

    public void delete(Long id) throws DepartmentDaoException {
        try (
                Connection con = getConnection();
                CallableStatement stmt = con.prepareCall("{call deletedepartmentbyid(?,?)}");
        ) {
            stmt.setLong(1, id);
            stmt.registerOutParameter(2, Types.BOOLEAN);
            stmt.execute();

            System.out.println(stmt.getBoolean(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Department getDepartment(Long id) throws DepartmentDaoException {
        Department department = new Department();
        try (
                Connection con = getConnection();
                CallableStatement stmt = con.prepareCall("{call findnamebyid(?,?)}");
        ) {
            stmt.setLong(1, id);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();

            //String name = stmt.getString(2);
            department.setId(id);
            department.setName(stmt.getString(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> findDepartments() throws DepartmentDaoException {
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
