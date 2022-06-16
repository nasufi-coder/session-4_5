import model.entity.Employee;
import repository.impl.EmployeeRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository emp=new EmployeeRepository();
        Employee empl= new Employee();
        empl.setId(132);
        empl.setEmail("test123");
        empl.setExtension("test123");
        empl.setFirstName("test");
        empl.setJobTitle("test123");
        empl.setLastName("test");
        empl.setOfficeCode("1");

        Boolean save = emp.save(empl);                                     //insert a new employee if not exists in DB
        System.out.println(save);

//        Boolean update = emp.update(empl);                                Update the employee
//        System.out.println(save);



//        List<Employee> employees=emp.findAll();                           //get all the Employees
//        for (Employee k : employees){
//            System.out.println(k.getFirstName());
//        }



//        Boolean exists=emp.exists(102);                               //check if specific employee exists
//        System.out.println(exists);




//        Employee employee=emp.findById(1002);                               //get a specific employee
//        System.out.println(employee.getFirstName());

    }

}
