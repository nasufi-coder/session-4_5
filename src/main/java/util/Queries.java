package util;

public final class Queries {

    private Queries() {}

    public static final String FIND_ALL_EMPLOYEES = "SELECT * FROM employees;";

    public static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE employeeNumber = ?;";


    public static final String EXISTS = "SELECT * FROM employees WHERE employeeNumber = ?;";


    public static final String INSERT = "Insert into employees values (?,?,?,?,?,?,?,?)";

    public static final String UPDATE = "update employees " +
            "set  employeeNumber=?," +
            "email=?," +
            "extension=?," +
            "firstName=?," +
            "jobTitle=?," +
            "lastName=?," +
            "officeCode=?," +
            "reportsTo=? " +
            "where employeeNumber=?";

}
