package demo.inheritance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.UserTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void case1_singleTable() throws Exception {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("hyq");
        employeeRepo.save(fullTimeEmployee);
        FullTimeEmployee fullTimeEmployee1 = employeeRepo.findFullTimeEmployeeById(fullTimeEmployee.getId());
        assertEquals(fullTimeEmployee.getName(), fullTimeEmployee1.getName());
        assertEquals(fullTimeEmployee.getSalary(), fullTimeEmployee1.getSalary());
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("shx");
        employeeRepo.save(partTimeEmployee);
        PartTimeEmployee partTimeEmployee1 = employeeRepo.findPartTimeEmployeeById(partTimeEmployee.getId());
        assertEquals(partTimeEmployee.getName(), partTimeEmployee1.getName());
        assertEquals(partTimeEmployee.getWage(), partTimeEmployee1.getWage());

        Employee employee = employeeRepo.findOne(fullTimeEmployee.getId());
        assertTrue(employee instanceof FullTimeEmployee);
    }

    @Test
    public void case2_tablePerClass() throws Exception {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("hyq");
        employeeRepo.save(fullTimeEmployee);
        FullTimeEmployee fullTimeEmployee1 = employeeRepo.findFullTimeEmployeeById(fullTimeEmployee.getId());
        assertEquals(fullTimeEmployee.getName(), fullTimeEmployee1.getName());
        assertEquals(fullTimeEmployee.getSalary(), fullTimeEmployee1.getSalary());
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("shx");
        employeeRepo.save(partTimeEmployee);
        PartTimeEmployee partTimeEmployee1 = employeeRepo.findPartTimeEmployeeById(partTimeEmployee.getId());
        assertEquals(partTimeEmployee.getName(), partTimeEmployee1.getName());
        assertEquals(partTimeEmployee.getWage(), partTimeEmployee1.getWage());

        Employee employee = employeeRepo.findOne(fullTimeEmployee.getId());
        assertTrue(employee instanceof FullTimeEmployee);
    }

    @Test
    public void case3_join() throws Exception {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("hyq");
        employeeRepo.save(fullTimeEmployee);
        FullTimeEmployee fullTimeEmployee1 = employeeRepo.findFullTimeEmployeeById(fullTimeEmployee.getId());
        assertEquals(fullTimeEmployee.getName(), fullTimeEmployee1.getName());
        assertEquals(fullTimeEmployee.getSalary(), fullTimeEmployee1.getSalary());
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("shx");
        employeeRepo.save(partTimeEmployee);
        PartTimeEmployee partTimeEmployee1 = employeeRepo.findPartTimeEmployeeById(partTimeEmployee.getId());
        assertEquals(partTimeEmployee.getName(), partTimeEmployee1.getName());
        assertEquals(partTimeEmployee.getWage(), partTimeEmployee1.getWage());

        Employee employee = employeeRepo.findOne(fullTimeEmployee.getId());
        assertTrue(employee instanceof FullTimeEmployee);
    }

}