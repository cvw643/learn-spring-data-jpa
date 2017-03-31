package demo.inheritance;

import javax.persistence.Entity;

/**
 * @author YQ.Huang
 */
@Entity
public class FullTimeEmployee extends Employee {

    private int salary;

    FullTimeEmployee() {
    }

    public FullTimeEmployee(String name) {
        super(name);
    }

    public int getSalary() {
        return salary;
    }

    public FullTimeEmployee setSalary(int salary) {
        this.salary = salary;
        return this;
    }
}
