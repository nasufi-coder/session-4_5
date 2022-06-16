package repository.impl;

import mapper.EmployeeMapper;
import model.entity.Employee;
import util.JdbcConnection;
import util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee, Integer> {

    public EmployeeRepository() {
        super(new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_ALL_EMPLOYEES)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Employee employee = getMapper().map(result);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.FIND_EMPLOYEE_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return getMapper().map(result);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public Boolean exists(Integer id) {
        // TODO: Implement a method which checks if an employee with the given id exists in the employees table
        try (Connection connection = JdbcConnection.connect(); PreparedStatement statement = connection.prepareStatement(Queries.EXISTS)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public Boolean save(Employee employee) {

        Boolean ex = exists(employee.getId());

        if (!ex == true) {
            try (Connection connection = JdbcConnection.connect();
                 PreparedStatement statement = connection.prepareStatement(Queries.INSERT)) {
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getEmail());
                statement.setString(3, employee.getExtension());
                statement.setString(4, employee.getFirstName());
                statement.setString(5, employee.getJobTitle());
                statement.setString(8, employee.getLastName());
                statement.setString(6, employee.getOfficeCode());
                statement.setInt(7, 1002);
                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
            return true;
        } else {
            update(employee);
            return true;
        }
    }

    @Override
    public Integer update(Employee employee) {
        Integer rowsUpdated;
        try (Connection connection = JdbcConnection.connect();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATE)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getExtension());
            statement.setString(4, employee.getFirstName());
            statement.setString(5, employee.getJobTitle());
            statement.setString(6, employee.getLastName());
            statement.setString(7, employee.getOfficeCode());
            statement.setInt(8, 1002);

            statement.setInt(9, employee.getId());
            rowsUpdated = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        return rowsUpdated;
    }

}
